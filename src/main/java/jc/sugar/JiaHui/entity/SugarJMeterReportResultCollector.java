package jc.sugar.JiaHui.entity;

import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.samplers.SampleEvent;

/**
 * @Code 谢良基 2021/7/5
 */
public class SugarJMeterReportResultCollector extends ResultCollector {

    private SugarReport report;


    public SugarJMeterReportResultCollector(SugarReport report){
        this.report = report;
    }


    @Override
    public void sampleOccurred(SampleEvent sampleEvent){
        super.sampleOccurred(sampleEvent);
        SugarJMeterRuntimeResultCollector.setSampleResultParentNull(sampleEvent.getResult());
        this.report.getSampleResultDeque().add(sampleEvent.getResult());
    }

    public SugarReport getReport() {
        return report;
    }

    public void setReport(SugarReport report) {
        this.report = report;
    }
}
