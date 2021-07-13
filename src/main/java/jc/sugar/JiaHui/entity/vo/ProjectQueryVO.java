package jc.sugar.JiaHui.entity.vo;

/**
 * @Code 谢良基 2021/6/25
 */
public class ProjectQueryVO {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目创建人用户名
     */
    private String creatorName;

    /**
     * 当前成员用户ID
     */
    private Integer accountId;

    private Integer pageSize;

    private Integer pageNum;

    public ProjectQueryVO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
