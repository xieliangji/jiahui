package jc.sugar.JiaHui.entity.dto;

import jc.sugar.JiaHui.entity.SugarReport.ReportStatus;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/7/6
 */
public class SugarReportDTO {

    private Integer id;

    private String name;

    private Integer testPlanId;

    private String testPlanName;

    private Integer projectId;

    private String projectName;

    private Integer creatorId;

    private String creatorName;

    private ReportStatus status;

    private String description;

    private ConcurrentLinkedDeque<SampleResult> results;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    public SugarReportDTO(){

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

    public String getTestPlanName() {
        return testPlanName;
    }

    public void setTestPlanName(String testPlanName) {
        this.testPlanName = testPlanName;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ConcurrentLinkedDeque<SampleResult> getResults() {
        return results;
    }

    public void setResults(ConcurrentLinkedDeque<SampleResult> results) {
        this.results = results;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
