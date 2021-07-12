package jc.sugar.JiaHui.utils;

import org.apache.jmeter.protocol.java.sampler.JSR223Sampler;
import org.apache.jmeter.util.JSR223TestElement;
import org.apache.logging.log4j.core.script.ScriptManager;

import javax.script.ScriptEngineManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Code 谢良基 2021/7/8
 */
public class SugarContextUtil {

    private static Thread MAIN_THREAD;


    public static void setMainThread(Thread mainThread){
        if(MAIN_THREAD == null){
            MAIN_THREAD = mainThread;
        }
    }


    public static Thread getMainThread(){
        return MAIN_THREAD;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JSR223Sampler sampler = new JSR223Sampler();
//        ScriptEngineManager engineManager = JSR223TestElement.getInstance();
//        Method method = ScriptEngineManager.class.getDeclaredMethod("init", ClassLoader.class);
//        System.out.println(method.getName());
//        method.setAccessible(true);
//        method.invoke(engineManager, Thread.currentThread().getContextClassLoader());
    }
}
