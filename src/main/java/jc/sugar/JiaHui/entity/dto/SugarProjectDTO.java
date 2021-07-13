package jc.sugar.JiaHui.entity.dto;

import java.util.Date;
import java.util.List;

/**
 * @Code 谢良基 2021/6/28
 */
public class SugarProjectDTO {

    /**
     * 项目ID
     */
    private Integer id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 项目备注
     */
    private String remark;

    /**
     * 项目创建人ID
     */
    private Integer creatorId;

    /**
     * 项目创建人名
     */
    private String creatorName;

    /**
     * 项目创建时间
     */
    private Date createTime;

    /**
     * 项目更新时间
     */
    private Date updateTime;



    private String updaterName;


    /**
     * 项目成员列表
     */
    private List<SugarAccountDTO> members;

    public SugarProjectDTO(){}

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

    public List<SugarAccountDTO> getMembers() {
        return members;
    }

    public void setMembers(List<SugarAccountDTO> members) {
        this.members = members;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }
}
