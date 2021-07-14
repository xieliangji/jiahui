package jc.sugar.JiaHui.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.dao.SugarReportDao;
import jc.sugar.JiaHui.dao.SugarTestPlanDao;
import jc.sugar.JiaHui.entity.SugarJMeterReportResultCollector;
import jc.sugar.JiaHui.entity.SugarReport;
import jc.sugar.JiaHui.entity.SugarTestPlan;
import jc.sugar.JiaHui.entity.dto.SugarTestPlanDTO;
import jc.sugar.JiaHui.entity.query.TestPlanQuery;
import jc.sugar.JiaHui.entity.vo.TestPlanExecuteVO;
import jc.sugar.JiaHui.entity.vo.TestPlanQueryVO;
import jc.sugar.JiaHui.entity.vo.TestPlanSaveVO;
import jc.sugar.JiaHui.entity.vo.TestPlanUpdateVO;
import jc.sugar.JiaHui.exception.SugarJMXException;
import jc.sugar.JiaHui.jmeter.JMeterHashTreeUtil;
import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import jc.sugar.JiaHui.jmeter.SugarJMeterContext;
import jc.sugar.JiaHui.service.SugarTestPlanService;
import jc.sugar.JiaHui.utils.GZipUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/7/5
 */
@Service
public class SugarTestPlanServiceImpl implements SugarTestPlanService {
    private final Logger log = LogManager.getLogger(SugarTestPlanServiceImpl.class);

    private final SugarTestPlanDao testPlanDao;


    private final SugarReportDao reportDao;

    public SugarTestPlanServiceImpl(SugarTestPlanDao testPlanDao, SugarReportDao reportDao){
        this.testPlanDao = testPlanDao;
        this.reportDao = reportDao;
    }

    @Override
    public SugarTestPlanDTO saveTestPlan(TestPlanSaveVO testPlanSaveVO) throws SugarJMXException, JsonProcessingException {
        if(StringUtils.isEmpty(testPlanSaveVO.getName())){
            throw new SugarJMXException("测试计划名称不能为空");
        }
        if(testPlanSaveVO.getProjectId() == null){
            throw new SugarJMXException("测试计划所属项目不能为空");
        }
        if(testPlanSaveVO.getCreatorId() == null){
            throw new SugarJMXException("测试计划创建人不能为空");
        }
        if(testPlanSaveVO.getHashTree() == null){
            throw new SugarJMXException("测试计划内容不能为空");
        }

        SugarTestPlan sugarTestPlan = new SugarTestPlan();
        sugarTestPlan.setName(testPlanSaveVO.getName());
        sugarTestPlan.setProjectId(testPlanSaveVO.getProjectId());
        sugarTestPlan.setCreatorId(testPlanSaveVO.getCreatorId());
        sugarTestPlan.setRemark(testPlanSaveVO.getRemark());
        String hashTreeJson = new ObjectMapper().writeValueAsString(testPlanSaveVO.getHashTree());
        sugarTestPlan.setHashTreeJson(GZipUtil.compress(hashTreeJson));
        try {
            testPlanDao.saveTestPlan(sugarTestPlan);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }

        SugarTestPlanDTO testPlanDTO = new SugarTestPlanDTO();
        testPlanDTO.setId(sugarTestPlan.getId());
        testPlanDTO.setName(testPlanSaveVO.getName());
        testPlanDTO.setProjectId(testPlanSaveVO.getProjectId());
        testPlanDTO.setCreatorId(testPlanSaveVO.getCreatorId());
        testPlanDTO.setRemark(testPlanSaveVO.getRemark());
        testPlanDTO.setHashTree(testPlanSaveVO.getHashTree());

        return testPlanDTO;
    }


    @Override
    public SugarTestPlanDTO updateTestPlan(TestPlanUpdateVO testPlanUpdateVO) throws SugarJMXException, JsonProcessingException {
        if(testPlanUpdateVO.getId() == null){
            throw new SugarJMXException("测试计划ID不能为空");
        }
        if(StringUtils.isEmpty(testPlanUpdateVO.getName())){
            throw new SugarJMXException("测试计划名称不能为空");
        }
        if(testPlanUpdateVO.getUpdaterId() == null){
            throw new SugarJMXException("测试计划更新人ID不能为空");
        }
        if(testPlanUpdateVO.getHashTree() == null){
            throw new SugarJMXException("测试计划内容不能更新为空");
        }

        SugarTestPlan sugarTestPlan = new SugarTestPlan();
        sugarTestPlan.setId(testPlanUpdateVO.getId());
        sugarTestPlan.setUpdaterId(testPlanUpdateVO.getUpdaterId());
        sugarTestPlan.setRemark(testPlanUpdateVO.getRemark());
        String hashTreeJson = new ObjectMapper().writeValueAsString(testPlanUpdateVO.getHashTree());
        sugarTestPlan.setHashTreeJson(GZipUtil.compress(hashTreeJson));
        try {
            testPlanDao.updateTestPlanById(sugarTestPlan);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }

        SugarTestPlanDTO testPlanDTO = new SugarTestPlanDTO();
        testPlanDTO.setId(testPlanUpdateVO.getId());
        testPlanDTO.setName(testPlanUpdateVO.getName());
        testPlanDTO.setUpdaterId(testPlanUpdateVO.getUpdaterId());
        testPlanDTO.setRemark(testPlanUpdateVO.getRemark());
        testPlanDTO.setHashTree(testPlanUpdateVO.getHashTree());

        return testPlanDTO;
    }



    @Override
    public PageInfo<SugarTestPlanDTO> queryTestPlan(TestPlanQueryVO testPlanQueryVO) throws SugarJMXException {
        if(testPlanQueryVO.getPageSize() == null || testPlanQueryVO.getPageNum() == null){
            PageHelper.startPage(1, 10);
        } else {
            PageHelper.startPage(testPlanQueryVO.getPageNum(), testPlanQueryVO.getPageSize());
        }

        TestPlanQuery jmxQuery = new TestPlanQuery();
        jmxQuery.setName(testPlanQueryVO.getName());
        jmxQuery.setProjectName(testPlanQueryVO.getProjectName());
        jmxQuery.setCreatorName(testPlanQueryVO.getCreatorName());
        jmxQuery.setUpdaterName(testPlanQueryVO.getUpdaterName());
        try {
            Page<SugarTestPlan> testPlans = testPlanDao.fetchTestPlan(jmxQuery);
            Page<SugarTestPlanDTO> dtos = new Page<>();
            dtos.setPageSize(testPlans.getPageSize());
            dtos.setPageNum(testPlans.getPageNum());
            dtos.setTotal(testPlans.getTotal());
            for(SugarTestPlan testPlan: testPlans){
                SugarTestPlanDTO testPlanDTO = new SugarTestPlanDTO();
                testPlanDTO.setId(testPlan.getId());
                testPlanDTO.setName(testPlan.getName());
                testPlanDTO.setProjectId(testPlan.getProjectId());
                testPlanDTO.setProjectName(testPlan.getProject().getName());
                testPlanDTO.setRemark(testPlan.getRemark());
                String compressedHashTree = testPlan.getHashTreeJson();
                List<Map<String, Object>> hashTreeJson = new ObjectMapper().readValue(GZipUtil.uncompress(compressedHashTree), List.class);
                testPlanDTO.setHashTree(hashTreeJson);
                testPlanDTO.setCreatorId(testPlan.getCreatorId());
                testPlanDTO.setCreatorName(testPlan.getCreator().getUsername());
                testPlanDTO.setCreateTime(testPlan.getCreateTime());
                if(testPlan.getUpdater() != null){
                    testPlanDTO.setUpdaterId(testPlan.getUpdaterId());
                    testPlanDTO.setUpdaterName(testPlan.getUpdater().getUsername());
                    testPlanDTO.setUpdateTime(testPlan.getUpdateTime());
                }
                dtos.add(testPlanDTO);
            }
            return dtos.toPageInfo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }



    @Override
    public SugarTestPlanDTO queryTestPlanById(Integer id) throws SugarJMXException {
        if(id == null){
            throw new SugarJMXException("测试计划ID不能为空");
        }
        try {
            SugarTestPlan testPlan = testPlanDao.fetchTestPlanById(id);
            if(testPlan == null){
                throw new SugarJMXException("测试计划不存在");
            }
            SugarTestPlanDTO testPlanDTO = new SugarTestPlanDTO();
            testPlanDTO.setId(testPlan.getId());
            testPlanDTO.setName(testPlan.getName());
            testPlanDTO.setProjectId(testPlan.getProjectId());
            testPlanDTO.setProjectName(testPlan.getProject().getName());
            testPlanDTO.setRemark(testPlan.getRemark());
            String compressedHashTree = testPlan.getHashTreeJson();
            List<Map<String, Object>> hashTreeJson = new ObjectMapper().readValue(GZipUtil.uncompress(compressedHashTree), List.class);
            testPlanDTO.setHashTree(hashTreeJson);
            testPlanDTO.setCreatorId(testPlan.getCreatorId());
            testPlanDTO.setCreatorName(testPlan.getCreator().getUsername());
            testPlanDTO.setCreateTime(testPlan.getCreateTime());
            if(testPlan.getUpdater() != null){
                testPlanDTO.setUpdaterId(testPlan.getUpdaterId());
                testPlanDTO.setUpdaterName(testPlan.getUpdater().getUsername());
                testPlanDTO.setUpdateTime(testPlan.getUpdateTime());
            }
            return testPlanDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }



    @Override
    public Integer deleteTestPlanById(Integer id) throws SugarJMXException {
        if(id == null){
            throw new SugarJMXException("测试计划ID不能为空");
        }
        try {
            return testPlanDao.deleteTestPlanById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }



    @Override
    public Boolean executeTestPlan(TestPlanExecuteVO executeVO) throws SugarJMXException {
        if(executeVO.getId() == null){
            throw new SugarJMXException("未指定执行的测试计划ID");
        }
        if(executeVO.getAccountId() == null){
            throw new SugarJMXException("测试计划执行人ID不能为空");
        }

        try {
            SugarJMeterContext.resetSugarJMeterContextClassLoader();

            SugarTestPlan testPlan = testPlanDao.fetchTestPlanById(executeVO.getId());
            String hashTreeJson = testPlan.getHashTreeJson();
            List<Map<String, Object>> hashTreeMap = new ObjectMapper().readValue(GZipUtil.uncompress(hashTreeJson), List.class);
            HashTree hashTree = JMeterHashTreeUtil.toHashTree(hashTreeMap);

            Thread executeThread = new Thread(() -> {
                JMeterInitializer.initialize();
                StandardJMeterEngine engine = new StandardJMeterEngine();

                log.info("测试计划 [" + testPlan.getName() + "] 开始执行...");
                SugarReport report = new SugarReport();
                Date startTime = new Date();
                report.setStartTime(startTime);
                report.setName("测试报告_" + new SimpleDateFormat("yyyyMMddHHmmss").format(startTime));
                report.setTestPlanId(testPlan.getId());
                report.setCreatorId(executeVO.getAccountId());

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
                        log.info("测试计划 [" + testPlan.getName() + "] 执行完成，已将测试报告保存至数据库.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            executeThread.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarJMXException(e);
        }
    }
}
