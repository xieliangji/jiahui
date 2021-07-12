package jc.sugar.JiaHui.entity.vo;

import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/7/5
 */
public class TestPlanSaveVO {

    private String name;


    private Integer projectId;


    private Integer creatorId;


    private String remark;


    private List<Map<String, Object>> hashTree;

    public TestPlanSaveVO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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
}
