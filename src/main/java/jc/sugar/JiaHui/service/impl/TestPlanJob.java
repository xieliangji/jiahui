package jc.sugar.JiaHui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jc.sugar.JiaHui.dao.SugarReportDao;
import jc.sugar.JiaHui.dao.SugarTaskDao;
import jc.sugar.JiaHui.dao.SugarTestPlanDao;
import jc.sugar.JiaHui.entity.SugarJMeterReportResultCollector;
import jc.sugar.JiaHui.entity.SugarReport;
import jc.sugar.JiaHui.entity.SugarTask;
import jc.sugar.JiaHui.entity.SugarTestPlan;
import jc.sugar.JiaHui.jmeter.JMeterHashTreeUtil;
import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import jc.sugar.JiaHui.utils.GZipUtil;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/7/19
 */
public class TestPlanJob implements Job {

    private static final Logger log = LogManager.getLogger(TestPlanJob.class);


    private final SugarTaskDao taskDao;


    private final SugarTestPlanDao testPlanDao;


    private final SugarReportDao reportDao;


    public TestPlanJob(SugarTaskDao taskDao, SugarTestPlanDao testPlanDao, SugarReportDao reportDao){
        this.taskDao = taskDao;
        this.testPlanDao =testPlanDao;
        this.reportDao = reportDao;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Integer taskId = Integer.parseInt(jobExecutionContext.getJobDetail().getKey().getName().split("-")[1]);
        try {
            SugarTask task = taskDao.fetchTaskById(taskId);
            SugarTestPlan testPlan = testPlanDao.fetchTestPlanById(task.getTestPlanId());

            String compressedHashTree = testPlan.getHashTreeJson();
            List<Map<String, Object>> hashTreeMap = new ObjectMapper().readValue(GZipUtil.uncompress(compressedHashTree), List.class);
            HashTree hashTree = JMeterHashTreeUtil.toHashTree(hashTreeMap);

            JMeterInitializer.initialize();
            StandardJMeterEngine engine = new StandardJMeterEngine();

            log.info("定时任务执行测试计划开始: " + testPlan.getName());
            SugarReport report = new SugarReport();
            Date startTime = new Date();
            report.setStartTime(startTime);
            report.setName(task.getName() + "_测试报告_" + new SimpleDateFormat("yyyyMMddHHmmss").format(startTime));
            report.setTestPlanId(testPlan.getId());
            report.setCreatorId(task.getCreatorId());

            SugarJMeterReportResultCollector resultCollector = new SugarJMeterReportResultCollector(report);
            Object testElement = hashTree.getArray()[0];
            if(testElement instanceof TestPlan){
                hashTree.add(testElement, resultCollector);
            } else {
                report.setStatus(SugarReport.ReportStatus.FAIL);
                report.setDescription("测试计划不合规范 - " + hashTreeMap);
                return;
            }

            JMeter.convertSubTree(hashTree, false);
            engine.configure(hashTree);
            engine.run();

            if(!engine.isActive()){
                report.setEndTime(new Date());
                report.setStatus(SugarReport.ReportStatus.SUCCESS);
                ConcurrentLinkedDeque<SampleResult> sampleResultDeque = report.getSampleResultDeque();
                try {
                    report.setSampleResults(GZipUtil.compress(new ObjectMapper().writeValueAsString(sampleResultDeque)));
                    reportDao.saveReport(report);
                    log.info("定时任务 [" + task.getName() + "] 执行测试计划 <" + testPlan.getName() + "> 执行完成，已将测试报告保存至数据库.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
