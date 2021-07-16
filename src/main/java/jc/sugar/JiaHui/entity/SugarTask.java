package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * @Code 谢良基 2021/7/16
 */
public class SugarTask {

    private Integer id;


    private String name;


    private Integer testPlanId;


    private SugarTestPlan testPlan;


    private Integer taskStatus;


    private String cronExpression;


    private String remark;


    private Integer creatorId;


    private SugarAccount creator;


    private Integer updaterId;


    private SugarAccount updater;


    private Date createTime;


    private Date updateTime;


    public SugarTask(){

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

    public Integer getTestPlanId() {
        return testPlanId;
    }

    public void setTestPlanId(Integer testPlanId) {
        this.testPlanId = testPlanId;
    }

    public SugarTestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(SugarTestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
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

    public SugarAccount getCreator() {
        return creator;
    }

    public void setCreator(SugarAccount creator) {
        this.creator = creator;
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


    public enum TaskStatus{
        DISABLED, ENABLED
    }
}
