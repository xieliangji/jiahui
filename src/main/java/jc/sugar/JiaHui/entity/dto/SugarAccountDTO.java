package jc.sugar.JiaHui.entity.dto;

import java.util.Date;

/**
 * @Code 谢良基 2021/6/23
 */
public class SugarAccountDTO {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户登录邮箱
     */
    private String email;

    /**
     * 用户注册时间
     */
    private Date createTime;

    /**
     * 用户信息最近一次更新时间
     */
    private Date updateTime;


    public SugarAccountDTO(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
