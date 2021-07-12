package jc.sugar.JiaHui.dao;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarReport;
import jc.sugar.JiaHui.entity.query.ReportQuery;

/**
 * @Code 谢良基 2021/7/6
 */
public interface SugarReportDao {

    Integer saveReport(SugarReport sugarReport) throws Exception;


    Page<SugarReport> fetchReports(ReportQuery reportQuery) throws Exception;


    Integer deleteReportById(Integer id) throws Exception;
}
