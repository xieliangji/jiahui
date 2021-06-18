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
@PropertySource("classpath:sugar.properties")
@Component
public class SugarProperties {

    /**
     * 上传文件保存的目录路径
     */
    private String uploadFilePath;



    public void setUploadFilePath(String uploadFilePath){
        this.uploadFilePath = uploadFilePath;
    }


    public String getUploadFilePath(){
        return uploadFilePath;
    }
}
