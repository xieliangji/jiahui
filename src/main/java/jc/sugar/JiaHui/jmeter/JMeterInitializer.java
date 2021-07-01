package jc.sugar.JiaHui.jmeter;


import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * 2021/5/26 13:56
 * Code by 谢良基
 */
public class JMeterInitializer {
    private static final Logger log = LogManager.getLogger(JMeterInitializer.class);


    private static String SEARCH_PATHS = "search_paths"; // jmeter查找类的路径

    public static final Map<String, StandardJMeterEngine> EXECUTORS = new HashMap<>();


    public static void initialize(){
        String JMETER_HOME;
        String JMETER_PROPERTIES_PATH;
        String JMETER_JAR_SEARCH_PATH;

        if(System.getProperty("publish") == null){
            log.warn("Current JMeter Running In Dev Environment. So please ignore this if you truly work in dev.");

            String JMETER_HOME_RESOURCE = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(".")).getPath()).getAbsolutePath();
            JMETER_HOME = JMETER_HOME_RESOURCE.concat("/jmeter");
            JMETER_JAR_SEARCH_PATH = System.getProperty("java.class.path");
        } else {
            log.info("Current JMeter Running In Prod Environment.");

            String appWorkDir = System.getProperty("user.dir");
            JMETER_HOME = appWorkDir.concat("/resources/jmeter");
            JMETER_JAR_SEARCH_PATH = appWorkDir.concat("/lib");
        }

        log.info("JMETER_HOME Environment Variable: " + JMETER_HOME);
        log.info("JMETER_JAR_SEARCH_PATH: " + JMETER_JAR_SEARCH_PATH);

        JMETER_PROPERTIES_PATH = JMETER_HOME.concat("/bin/jmeter.properties");
        JMeterUtils.setJMeterHome(JMETER_HOME);
        JMeterUtils.loadJMeterProperties(JMETER_PROPERTIES_PATH);
        JMeterUtils.setLocale(Locale.SIMPLIFIED_CHINESE);
        JMeterUtils.setProperty(SEARCH_PATHS, JMETER_JAR_SEARCH_PATH);
    }


    public static String getResourceRoot(){
        if(System.getProperty("publish") == null){
            return new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(".")).getPath()).getAbsolutePath();
        } else {
            return System.getProperty("user.dir");
        }
    }
}
