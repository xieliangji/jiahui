package jc.sugar.JiaHui.wo;

import java.util.List;

/**
 * @Code 谢良基 2021/6/25
 */
public class SugarProjectSaveWO {
    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目备注
     */
    private String remark;

    /**
     * 项目创建用户ID
     */
    private String creatorId;

    /**
     * 项目成员用户ID
     */
    private List<Integer> memberIds;

    public SugarProjectSaveWO(){}

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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}
