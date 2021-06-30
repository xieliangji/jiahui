package jc.sugar.JiaHui.entity.vo;

import java.util.List;

/**
 * @Code 谢良基 2021/6/25
 */
public class ProjectUpdateVO extends ProjectSaveVO{
    private Integer id;

    private String name;

    private String remark;

    private Integer accountId;

    private List<Integer> memberIds;

    public ProjectUpdateVO(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public List<Integer> getMemberIds() {
        return memberIds;
    }

    @Override
    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}
