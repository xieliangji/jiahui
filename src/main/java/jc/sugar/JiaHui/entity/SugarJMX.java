package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * 2021/5/25 11:43
 * Code by 谢良基
 */
public class SugarJMX {

    /**
     * 测试计划ID
     */
    private Integer id;


    /**
     * 测试计划名称
     */
    private String name;


    /**
     * 测试计划所属项目ID
     */
    private Integer projectId;


    /**
     * 测试计划jmx文件名
     */
    private String jmxPath;


    /**
     * 测试计划备注
     */
    private String remark;


    /**
     * 测试计划创建人用户ID
     */
    private Integer creatorId;


    /**
     * 测试计划最近更新人用户ID
     */
    private Integer updaterId;


    /**
     * 测试计划创建时间
     */
    private Date createTime;


    /**
     * 测试计划最近一次更新时间
     */
    private Date updateTime;


    /**
     * 所属项目实体
     */
    private SugarProject project;


    /**
     * 创建人账户实体
     */
    private SugarAccount creator;


    /**
     * 更新人账户实体
     */
    private SugarAccount updater;

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

    public String getJmxPath() {
        return jmxPath;
    }

    public void setJmxPath(String jmxPath) {
        this.jmxPath = jmxPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public SugarProject getProject() {
        return project;
    }

    public void setProject(SugarProject project) {
        this.project = project;
    }

    public SugarAccount getCreator() {
        return creator;
    }

    public void setCreator(SugarAccount creator) {
        this.creator = creator;
    }

    public SugarAccount getUpdater() {
        return updater;
    }

    public void setUpdater(SugarAccount updater) {
        this.updater = updater;
    }
}
