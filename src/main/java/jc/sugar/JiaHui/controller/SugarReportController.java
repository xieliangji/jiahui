package jc.sugar.JiaHui.controller;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.dto.SugarReportDTO;
import jc.sugar.JiaHui.entity.vo.ReportQueryVO;
import jc.sugar.JiaHui.exception.SugarReportException;
import jc.sugar.JiaHui.service.SugarReportService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Code 谢良基 2021/7/6
 */
@RestController
@RequestMapping("/sugar-report")
public class SugarReportController {

    private final SugarReportService reportService;


    public SugarReportController(SugarReportService reportService){
        this.reportService = reportService;
    }



    @ResponseBody
    @RequestMapping("/query")
    public SugarResponse<PageInfo<SugarReportDTO>> queryReports(@RequestBody ReportQueryVO reportQueryVO){
        try {
            PageInfo<SugarReportDTO> payload = reportService.fetchReports(reportQueryVO);
            return SugarResponse.success(payload, "");
        } catch (SugarReportException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/delete")
    public SugarResponse<Integer> deleteReport(Integer id){
        try {
            Integer payload = reportService.deleteReport(id);
            return SugarResponse.success(payload, "");
        } catch (SugarReportException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
