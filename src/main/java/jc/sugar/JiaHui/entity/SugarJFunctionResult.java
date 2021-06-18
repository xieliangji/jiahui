package jc.sugar.JiaHui.entity;

/**
 * 2021/5/26 11:31
 * Code by 谢良基
 */
public class SugarJFunctionResult {

    private Integer id;


    private String result;


    private String jmeterVariables;


    private String expression;


    public SugarJFunctionResult(String result, String jmeterVariables, String expression){
        this.id = System.identityHashCode(this);
        this.result = result;
        this.jmeterVariables = jmeterVariables;
        this.expression = expression;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getJmeterVariables() {
        return jmeterVariables;
    }

    public void setJmeterVariables(String jmeterVariables) {
        this.jmeterVariables = jmeterVariables;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
