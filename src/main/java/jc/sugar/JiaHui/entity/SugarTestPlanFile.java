package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * @Code 谢良基 2021/7/19
 */
public class SugarTestPlanFile {
    private Integer id;


    private String fileName;


    private String filePath;


    private Integer uploaderId;


    private SugarAccount uploader;


    private Date uploadTime;


    public SugarTestPlanFile(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
    }

    public SugarAccount getUploader() {
        return uploader;
    }

    public void setUploader(SugarAccount uploader) {
        this.uploader = uploader;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
