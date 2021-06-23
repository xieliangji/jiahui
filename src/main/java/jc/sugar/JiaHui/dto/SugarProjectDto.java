package jc.sugar.JiaHui.dto;

import java.util.Date;
import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
public class SugarProjectDto {

    private Integer id;

    private String name;

    private String remark;

    private Integer creatorId;

    private Date createTime;

    private Date updateTime;

    private List<SugarAccountDto> members;

    private List<Integer> memberIds;

    public SugarProjectDto(){}

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

    public List<SugarAccountDto> getMembers() {
        return members;
    }

    public void setMembers(List<SugarAccountDto> members) {
        this.members = members;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}
