package jc.sugar.JiaHui.entity;

import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.util.JMeterUtils;

/**
 * @Code 谢良基 2021/6/30
 */
public class SugarJMeterSampleEvent {

    private String resultType;

    private SampleEvent sampleEvent;

    public SugarJMeterSampleEvent(SampleEvent sampleEvent){
        this.sampleEvent = sampleEvent;
        String sampleResultClassName = sampleEvent.getResult().getClass().getName();
        this.resultType = sampleResultClassName.substring(1 + sampleResultClassName.lastIndexOf('.')) + " " + JMeterUtils.getResString("view_results_fields");
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public SampleEvent getSampleEvent() {
        return sampleEvent;
    }

    public void setSampleEvent(SampleEvent sampleEvent) {
        this.sampleEvent = sampleEvent;
    }
}
