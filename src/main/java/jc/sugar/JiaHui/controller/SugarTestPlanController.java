package jc.sugar.JiaHui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.dto.SugarTestPlanDTO;
import jc.sugar.JiaHui.entity.vo.TestPlanExecuteVO;
import jc.sugar.JiaHui.entity.vo.TestPlanQueryVO;
import jc.sugar.JiaHui.entity.vo.TestPlanSaveVO;
import jc.sugar.JiaHui.entity.vo.TestPlanUpdateVO;
import jc.sugar.JiaHui.exception.SugarJMXException;
import jc.sugar.JiaHui.service.SugarTestPlanService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Code 谢良基 2021/7/5
 */
@RestController
@RequestMapping("/sugar-test-plan")
public class SugarTestPlanController {

    private final SugarTestPlanService testPlanService;


    public SugarTestPlanController(SugarTestPlanService testPlanService){
        this.testPlanService = testPlanService;
    }


    @RequestMapping("/save")
    @ResponseBody
    public SugarResponse<SugarTestPlanDTO> saveTestPlan(@RequestBody TestPlanSaveVO testPlanSaveVO){
        try {
            SugarTestPlanDTO payload = testPlanService.saveTestPlan(testPlanSaveVO);
            return SugarResponse.success(payload, "");
        } catch (SugarJMXException | JsonProcessingException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/update")
    @ResponseBody
    public SugarResponse<SugarTestPlanDTO> updateTestPlan(@RequestBody TestPlanUpdateVO testPlanUpdateVO){
        try {
            SugarTestPlanDTO payload = testPlanService.updateTestPlan(testPlanUpdateVO);
            return SugarResponse.success(payload, "");
        } catch (SugarJMXException | JsonProcessingException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/query")
    @ResponseBody
    public SugarResponse<PageInfo<SugarTestPlanDTO>> queryTestPlan(@RequestBody TestPlanQueryVO testPlanQueryVO){
        try {
            PageInfo<SugarTestPlanDTO> payload = testPlanService.queryTestPlan(testPlanQueryVO);
            return SugarResponse.success(payload, "");
        } catch (SugarJMXException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/delete")
    @ResponseBody
    public SugarResponse<Integer> deleteTestPlan(Integer id){
        try {
            Integer payload = testPlanService.deleteTestPlanById(id);
            return SugarResponse.success(payload, "");
        } catch (SugarJMXException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/execute")
    @ResponseBody
    public SugarResponse<Boolean> executeTestPlan(@RequestBody TestPlanExecuteVO testPlanExecuteVO){
        try {
            Boolean payload = testPlanService.executeTestPlan(testPlanExecuteVO);
            if(payload){
                return SugarResponse.success(true, "");
            } else {
                throw new SugarJMXException("Execute TestPlan Failed.");
            }
        } catch (SugarJMXException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
