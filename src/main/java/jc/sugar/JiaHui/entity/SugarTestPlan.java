package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * @Code 谢良基 2021/7/5
 */
public class SugarTestPlan {

    /**
     * 测试计划ID
     */
    private Integer id;


    /**
     * 测试计划名
     */
    private String name;


    /**
     * 测试计划所属项目ID
     */
    private Integer projectId;


    private SugarProject project;

    /**
     * 测试计划备注
     */
    private String remark;


    /**
     * 测试计划HashTree压缩后的json格式字符串内容
     */
    private String hashTreeJson;


    /**
     * 测试计划创建人ID
     */
    private Integer creatorId;


    private SugarAccount creator;


    /**
     * 测试计划创建时间
     */
    private Date createTime;


    /**
     * 测试计划更新人ID
     */
    private Integer updaterId;


    private SugarAccount updater;


    /**
     * 测试计划更新时间
     */
    private Date updateTime;


    public SugarTestPlan(){

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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHashTreeJson() {
        return hashTreeJson;
    }

    public void setHashTreeJson(String hashTreeJson) {
        this.hashTreeJson = hashTreeJson;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
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
