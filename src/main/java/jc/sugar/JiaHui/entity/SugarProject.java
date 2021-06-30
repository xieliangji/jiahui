package jc.sugar.JiaHui.entity;

import java.util.Date;
import java.util.List;

/**
 * 2021/5/25 11:13
 * Code by 谢良基
 */
public class SugarProject {

    private Integer id;


    private String name;


    private String remark;


    private Integer creatorId;


    private Integer updaterId;


    private Date createTime;


    private Date updateTime;


    private List<SugarAccount> members;


    public SugarProject(){

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

    public List<SugarAccount> getMembers() {
        return members;
    }

    public void setMembers(List<SugarAccount> members) {
        this.members = members;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }
}
