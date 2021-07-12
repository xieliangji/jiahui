package jc.sugar.JiaHui.service;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.dto.SugarReportDTO;
import jc.sugar.JiaHui.entity.vo.ReportQueryVO;
import jc.sugar.JiaHui.exception.SugarReportException;

/**
 * @Code 谢良基 2021/7/6
 */
public interface SugarReportService {

    PageInfo<SugarReportDTO> fetchReports(ReportQueryVO reportQueryVO) throws SugarReportException;

    Integer deleteReport(Integer id) throws SugarReportException;
}
