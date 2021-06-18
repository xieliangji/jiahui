package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * 2021/5/25 11:43
 * Code by 谢良基
 */
public class SugarJMX {

    private Integer id;


    private String name;


    private Integer projectId;


    private String jmxContent;


    private Integer creatorId;


    private Integer updaterId;


    private Date createTime;


    private Date updateTime;


    public SugarJMX(){}


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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getJmxContent() {
        return jmxContent;
    }

    public void setJmxContent(String jmxContent) {
        this.jmxContent = jmxContent;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
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
