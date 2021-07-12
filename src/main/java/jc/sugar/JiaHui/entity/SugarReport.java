package jc.sugar.JiaHui.entity;

import org.apache.jmeter.samplers.SampleResult;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/7/2
 */
public class SugarReport {

    private Integer id;


    private String name;


    private Integer testPlanId;


    private Date startTime;


    private Date endTime;


    private Integer creatorId;


    private SugarAccount creator;


    private Date createTime;


    private SugarTestPlan testPlan;


    private ReportStatus status;


    private String sampleResults;


    private String description;


    private ConcurrentLinkedDeque<SampleResult> sampleResultDeque;


    public SugarReport(){
        this.sampleResultDeque = new ConcurrentLinkedDeque<>();
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

    public Integer getTestPlanId() {
        return testPlanId;
    }

    public void setTestPlanId(Integer testPlanId) {
        this.testPlanId = testPlanId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public SugarAccount getCreator() {
        return creator;
    }

    public void setCreator(SugarAccount creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SugarTestPlan getTestPlan() {
        return testPlan;
    }

    public void setTestPlan(SugarTestPlan testPlan) {
        this.testPlan = testPlan;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getSampleResults() {
        return sampleResults;
    }

    public void setSampleResults(String sampleResults) {
        this.sampleResults = sampleResults;
    }

    public ConcurrentLinkedDeque<SampleResult> getSampleResultDeque() {
        return sampleResultDeque;
    }

    public void setSampleResultDeque(ConcurrentLinkedDeque<SampleResult> sampleResultDeque) {
        this.sampleResultDeque = sampleResultDeque;
    }

    public enum ReportStatus{
        FAIL, SUCCESS
    }
}
