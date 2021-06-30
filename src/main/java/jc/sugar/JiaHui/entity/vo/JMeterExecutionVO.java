package jc.sugar.JiaHui.entity.vo;

import java.util.List;
import java.util.Map;

/**
 * @Code 谢良基 2021/6/28
 */
public class JMeterExecutionVO {

    private String executorId;

    private List<Map<String, Object>> testPlanList;

    public JMeterExecutionVO(){

    }

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

    public List<Map<String, Object>> getTestPlanList() {
        return testPlanList;
    }

    public void setTestPlanList(List<Map<String, Object>> testPlanList) {
        this.testPlanList = testPlanList;
    }
}
