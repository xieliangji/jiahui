package jc.sugar.JiaHui.entity.query;

/**
 * @Code 谢良基 2021/6/28
 */
public class ProjectQuery {

    String name;

    String creatorName;

    Integer accountId;

    public ProjectQuery(){}


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
}
