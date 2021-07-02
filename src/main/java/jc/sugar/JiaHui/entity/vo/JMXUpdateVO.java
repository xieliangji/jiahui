package jc.sugar.JiaHui.entity.vo;

import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/7/1
 */
public class JMXUpdateVO {
    private Integer id;

    private String name;

    private List<Map<String, Object>> jmxContent;

    private String remark;

    private Integer updaterId;

    public JMXUpdateVO(){}

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

    public List<Map<String, Object>> getJmxContent() {
        return jmxContent;
    }

    public void setJmxContent(List<Map<String, Object>> jmxContent) {
        this.jmxContent = jmxContent;
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
