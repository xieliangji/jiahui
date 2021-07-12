package jc.sugar.JiaHui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.dao.SugarReportDao;
import jc.sugar.JiaHui.entity.SugarReport;
import jc.sugar.JiaHui.entity.dto.SugarReportDTO;
import jc.sugar.JiaHui.entity.query.ReportQuery;
import jc.sugar.JiaHui.entity.vo.ReportQueryVO;
import jc.sugar.JiaHui.exception.SugarReportException;
import jc.sugar.JiaHui.service.SugarReportService;
import jc.sugar.JiaHui.utils.GZipUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/7/6
 */
@Service
public class SugarReportServiceImpl implements SugarReportService {

    private final Logger log = LogManager.getLogger(SugarReportServiceImpl.class);

    private final SugarReportDao reportDao;


    public SugarReportServiceImpl(SugarReportDao reportDao){
        this.reportDao = reportDao;
    }



    @Override
    public PageInfo<SugarReportDTO> fetchReports(ReportQueryVO reportQueryVO) throws SugarReportException {
        if(reportQueryVO.getAccountId() == null){
            throw new SugarReportException("未指定报告查询人ID");
        }
        if(reportQueryVO.getPageNum() == null || reportQueryVO.getPageSize() == null){
            PageHelper.startPage(1, 10);
        } else {
            PageHelper.startPage(reportQueryVO.getPageNum(), reportQueryVO.getPageSize());
        }

        ReportQuery query = new ReportQuery();
        query.setName(reportQueryVO.getName());
        query.setTestPlanName(reportQueryVO.getTestPlanName());
        query.setProjectName(reportQueryVO.getProjectName());
        query.setCreatorName(reportQueryVO.getCreatorName());
        query.setCreateStartTime(reportQueryVO.getCreateStartTime());
        query.setCreateEndTime(reportQueryVO.getCreateEndTime());
        query.setAccountId(reportQueryVO.getAccountId());

        try {
            Page<SugarReport> reports = reportDao.fetchReports(query);
            Page<SugarReportDTO> reportDTOS = new Page<>();
            for(SugarReport report: reports){
                SugarReportDTO reportDTO = new SugarReportDTO();
                reportDTO.setId(report.getId());
                reportDTO.setName(report.getName());
                reportDTO.setTestPlanId(report.getTestPlanId());
                reportDTO.setTestPlanName(report.getTestPlan().getName());
                reportDTO.setProjectId(report.getTestPlan().getProjectId());
                reportDTO.setProjectName(report.getTestPlan().getProject().getName());
                reportDTO.setCreatorId(report.getCreatorId());
                reportDTO.setCreatorName(report.getCreator().getUsername());
                reportDTO.setStatus(report.getStatus());
                reportDTO.setDescription(report.getDescription());
                String sampleResults = GZipUtil.uncompress(report.getSampleResults());
                reportDTO.setResults(new ObjectMapper().readValue(sampleResults, ConcurrentLinkedDeque.class));
                reportDTO.setStartTime(report.getStartTime());
                reportDTO.setEndTime(report.getEndTime());
                reportDTO.setCreateTime(report.getCreateTime());

                reportDTOS.add(reportDTO);
            }
            reportDTOS.setPageNum(reports.getPageNum());
            reportDTOS.setPageSize(reports.getPageSize());
            reportDTOS.setTotal(reports.getTotal());
            return reportDTOS.toPageInfo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarReportException(e);
        }
    }

    public Integer deleteReport(Integer id) throws SugarReportException {
        if(id == null){
            throw new SugarReportException("不存在该测试报告或已被删除");
        }

        try {
            return reportDao.deleteReportById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarReportException(e);
        }
    }
}
