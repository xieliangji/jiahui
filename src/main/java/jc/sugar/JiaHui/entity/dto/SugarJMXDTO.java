package jc.sugar.JiaHui.entity.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/7/1
 */
public class SugarJMXDTO {
    private Integer id;

    private String name;

    private List<Map<String, Object>> jmxContent;

    private String remark;

    private Integer projectId;

    private String projectName;

    private Integer creatorId;

    private String creatorName;

    private Integer updaterId;

    private String updaterName;

    private Date createTime;

    private Date updateTime;

    public SugarJMXDTO(){

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

    public List<Map<String, Object>> getJmxContent() {
        return jmxContent;
    }

    public void setJmxContent(List<Map<String, Object>> jmxContent) {
        this.jmxContent = jmxContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
