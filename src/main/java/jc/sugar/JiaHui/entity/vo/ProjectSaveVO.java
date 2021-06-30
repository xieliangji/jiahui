package jc.sugar.JiaHui.entity.vo;

import java.util.List;

/**
 * @Code 谢良基 2021/6/25
 */
public class ProjectSaveVO {

    private String name;

    private String remark;

    private Integer creatorId;

    private List<Integer> memberIds;

    public ProjectSaveVO(){}

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

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}
