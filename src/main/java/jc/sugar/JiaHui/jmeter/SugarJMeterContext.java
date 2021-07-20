package jc.sugar.JiaHui.jmeter;

import org.apache.jmeter.control.IfController;
import org.apache.jmeter.util.JSR223TestElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Code 谢良基 2021/7/8
 *
 * 解决jar包的热加载、热卸载
 *
 * 通过自定义一个URLClassLoader来完成。
 * 1) 服务启动时，就使用自定义类加载器设置为主线程的上下文类加载器（原主线程的上下文类加载器设置为自定义类加载器的父加载器）
 * 2) 当jar包有更新时（上传或删除），把原自定义类加载器销毁，更新新的自定义类加载器。
 */
@Component
public class SugarJMeterContext {


    private static URLClassLoader JMETER_LOADER;

    private static String UPLOAD_ROOT;


    private static String TEST_UPLOAD_ROOT;


    @Value("${sugar.upload-root}")
    public void setUploadRoot(String uploadRoot){
        UPLOAD_ROOT = uploadRoot;
    }


    public static String getUploadRoot(){
        return UPLOAD_ROOT;
    }


    @Value("${sugar.test-upload-root}")
    public void setTestUploadRoot(String testUploadRoot){
        TEST_UPLOAD_ROOT = testUploadRoot;
    }


    public static String getTestUploadRoot(){
        return TEST_UPLOAD_ROOT;
    }

    public static synchronized void destroyJMeterLoader(){
        if(JMETER_LOADER != null){
            try {
                JMETER_LOADER.close();
                JMETER_LOADER = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void reInitJMeterScriptEngineManager(final ClassLoader loader){
        try {
            if(loader.getParent() == null){
                throw new IllegalStateException("New ScriptEngineManager's custom classloader not specified Parent classloader!");
            }

            // fetch init method by reflection.
            Method initMethod = ScriptEngineManager.class.getDeclaredMethod("init", ClassLoader.class);
            initMethod.setAccessible(true);

            // 1、 ScriptEngineManager In JSR223TestElement.
            ScriptEngineManager jsr223SEM = JSR223TestElement.getInstance();
            initMethod.invoke(jsr223SEM, loader);

            // 2、 ScriptEngineManager In IfController.
            Method getInstanceMethod = IfController.class.getDeclaredMethod("getInstance");
            getInstanceMethod.setAccessible(true);
            ScriptEngineManager ifSEM = (ScriptEngineManager) getInstanceMethod.invoke(IfController.class);
            initMethod.invoke(ifSEM, loader);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建一个返回加载libJarDirectory目录下jar包的URLClassLoader.
     * @return
     */
    private static URLClassLoader createLibJarClassLoader(ClassLoader parent) throws IOException {
        List<URL> urls = new ArrayList<>();

        File uploadRootFile = new File(UPLOAD_ROOT);
        if(!uploadRootFile.exists() || !uploadRootFile.isDirectory()){
            throw new IOException("加载jar|zip目录不存在");
        }

        urls.add(Paths.get(UPLOAD_ROOT).toUri().toURL());
        File[] zipJarFiles = uploadRootFile.listFiles(file -> file.getName().endsWith(".jar") || file.getName().endsWith(".zip"));
        for(File file: zipJarFiles == null ? new File[0]: zipJarFiles){
            urls.add(file.toURI().toURL());
        }

        URL[] urlArray = new URL[urls.size()];
        return new URLClassLoader(urls.toArray(urlArray), parent);
    }


    public static synchronized void resetSugarJMeterContextClassLoader() throws IOException {
        ClassLoader parent;
        if(JMETER_LOADER != null){
            parent = JMETER_LOADER.getParent();
            JMETER_LOADER.close();
        } else {
            parent = Thread.currentThread().getContextClassLoader();
        }

        JMETER_LOADER = createLibJarClassLoader(parent);
        Thread.currentThread().setContextClassLoader(JMETER_LOADER);
        reInitJMeterScriptEngineManager(JMETER_LOADER);
    }
}
