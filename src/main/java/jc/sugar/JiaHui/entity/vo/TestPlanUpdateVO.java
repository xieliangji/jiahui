package jc.sugar.JiaHui.entity.vo;

import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/7/5
 */
public class TestPlanUpdateVO {

    private Integer id;


    private String name;


    private String remark;


    private List<Map<String, Object>> hashTree;


    private Integer updaterId;


    public TestPlanUpdateVO(){

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

    public List<Map<String, Object>> getHashTree() {
        return hashTree;
    }

    public void setHashTree(List<Map<String, Object>> hashTree) {
        this.hashTree = hashTree;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }
}
