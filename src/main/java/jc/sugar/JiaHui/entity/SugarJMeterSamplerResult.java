package jc.sugar.JiaHui.entity;

import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.util.JMeterUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Code 谢良基 2021/7/2
 */
public class SugarJMeterSamplerResult extends SampleResult{

    private String resultType;

    private List<SugarJMeterSamplerResult> childResults;

    public SugarJMeterSamplerResult(SampleResult sampleResult){
        super(sampleResult);
        extractSampleResult(sampleResult);
    }


    private void extractSampleResult(SampleResult sampleResult){
        String sampleResultClass = sampleResult.getClass().getName();
        this.resultType = sampleResultClass.substring(1 + sampleResultClass.lastIndexOf('.')) + " " + JMeterUtils.getResString("view_results_fields");

        this.childResults = new ArrayList<>();
        for(SampleResult subSampleResult: sampleResult.getSubResults()){
            childResults.add(new SugarJMeterSamplerResult(subSampleResult));
        }
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public List<SugarJMeterSamplerResult> getChildResults() {
        return childResults;
    }

    public void setChildResults(List<SugarJMeterSamplerResult> childResults) {
        this.childResults = childResults;
    }
}
