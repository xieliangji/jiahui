package jc.sugar.JiaHui.entity.vo;

import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/7/1
 */
public class JMXSaveVO {

    private String name;

    private Integer projectId;

    private String remark;

    private List<Map<String, Object>> jmxContent;

    private Integer creatorId;

    public JMXSaveVO(){}

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Map<String, Object>> getJmxContent() {
        return jmxContent;
    }

    public void setJmxContent(List<Map<String, Object>> jmxContent) {
        this.jmxContent = jmxContent;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}
