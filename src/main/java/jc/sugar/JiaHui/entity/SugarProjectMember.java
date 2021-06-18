package jc.sugar.JiaHui.entity;

import java.util.Date;

/**
 * 2021/5/25 11:15
 * Code by 谢良基
 */
public class SugarProjectMember {

    private Integer id;


    private Integer projectId;


    private Integer accountId;


    private Date createTime;


    public SugarProjectMember(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
