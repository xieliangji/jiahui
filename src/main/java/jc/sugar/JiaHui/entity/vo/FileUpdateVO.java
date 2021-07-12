package jc.sugar.JiaHui.entity.vo;

/**
 * @Code 谢良基 2021/7/12
 */
public class FileUpdateVO {
    private Integer id;

    private String name;

    private String remark;

    private Integer updaterId;

    public FileUpdateVO(){}

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

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }
}
