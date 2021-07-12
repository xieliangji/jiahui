package jc.sugar.JiaHui.entity.query;

/**
 * @Code 谢良基 2021/7/12
 */
public class FileQuery {

    private Integer pageSize;

    private Integer pageNum;

    private String name;

    private String uploaderName;

    private Integer fileType;

    private String uploadStartTime;

    private String uploadEndTime;

    public FileQuery(){

    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getUploadStartTime() {
        return uploadStartTime;
    }

    public void setUploadStartTime(String uploadStartTime) {
        this.uploadStartTime = uploadStartTime;
    }

    public String getUploadEndTime() {
        return uploadEndTime;
    }

    public void setUploadEndTime(String uploadEndTime) {
        this.uploadEndTime = uploadEndTime;
    }
}
