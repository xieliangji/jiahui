package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * 2021/5/25 11:20
 * Code by 谢良基
 */
public class SugarFile {


    private Integer id;


    private String name;


    private String fileName;


    private Integer fileType;


    private String remark;


    private Integer uploaderId;


    private SugarAccount uploader;


    private Integer updaterId;


    private SugarAccount updater;


    private Date uploadTime;


    private Date updateTime;


    public SugarFile(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public SugarAccount getUpdater() {
        return updater;
    }

    public void setUpdater(SugarAccount updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
}
