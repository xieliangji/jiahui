package jc.sugar.JiaHui.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @Code 谢良基 2021/7/7
 *
 * 上传一个jar包则对应使用一个URLClassLoader
 */
public class SugarClassLoaderUtil {


    public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
        URLClassLoader loader = loadJar("C:\\Users\\Administrator\\Desktop\\ZF.jar", null);
        Class clazz = loader.loadClass("com.zfzf.Hex");
        Method[] methods = clazz.getDeclaredMethods();
//        loader.close();
//        while (new Scanner(System.in).nextBoolean()){
//            System.out.println("fuck");
//        }

//        for(Method method: methods){
//            System.out.println(method.getName());
//        }
        System.out.println(loader.loadClass("com.zfzf.MysqlUtil"));

//        Thread.sleep(5000);
        System.out.println(loader.loadClass("com.zfzf.HttpUtil"));
    }


    public static URLClassLoader loadJar(String jarPath, ClassLoader parent) throws IOException {
        URL jarURL = Paths.get(jarPath).toUri().toURL();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL}, parent);

        return classLoader;
    }


    public static void unloadJars(){

    }


    public static void unloadJar(String jarName){



    }

}
