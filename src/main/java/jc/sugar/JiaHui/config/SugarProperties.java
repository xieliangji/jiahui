package jc.sugar.JiaHui.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 2021/5/25 11:50
 * Code by 谢良基
 */
@ConfigurationProperties(prefix = "sugar")
@EnableConfigurationProperties(SugarProperties.class)
@Component
public class SugarProperties {

    /**
     * 上传文件保存的目录路径
     */
    private String uploadRoot;


    /**
     * JMeter 测试计划jmx文件存储目录路径
     */
    private String jmxRoot;


    public SugarProperties(){}

    public String getUploadRoot() {
        return uploadRoot;
    }

    public void setUploadRoot(String uploadRoot) {
        this.uploadRoot = uploadRoot;
    }

    public String getJmxRoot() {
        return jmxRoot;
    }

    public void setJmxRoot(String jmxRoot) {
        this.jmxRoot = jmxRoot;
    }
}
