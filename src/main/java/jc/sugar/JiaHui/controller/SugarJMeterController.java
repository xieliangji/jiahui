package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.entity.SugarJFunction;
import jc.sugar.JiaHui.entity.SugarJFunctionResult;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.vo.JMeterExecutionVO;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterExecutionException;
import jc.sugar.JiaHui.jmeter.function.JMeterFunctionUtil;
import jc.sugar.JiaHui.service.SugarJMeterService;
import org.apache.jmeter.samplers.SampleEvent;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/6/22
 */
@RestController
@RequestMapping("/sugar-jmeter")
public class SugarJMeterController {

    private final SugarJMeterService jMeterService;

    public SugarJMeterController(SugarJMeterService jMeterService) {
        this.jMeterService = jMeterService;
    }

    @RequestMapping("/functions")
    @ResponseBody
    public SugarResponse<List<SugarJFunction>> getJMeterFunctions(){
        try {
            List<SugarJFunction> functions = JMeterFunctionUtil.getSugarJFunctions();
            return SugarResponse.success(functions, "");
        } catch (Exception e){
            return SugarResponse.fail(e.getMessage());
        }
    }


    @RequestMapping("/execute-function")
    @ResponseBody
    public SugarResponse<SugarJFunctionResult> callJMeterFunction(@RequestBody SugarJFunction jmeterFunction){
        try {
            SugarJFunctionResult functionCallResult = JMeterFunctionUtil.execute(jmeterFunction);
            return SugarResponse.success(functionCallResult, "");
        } catch (Exception e){
            e.printStackTrace();
            return SugarResponse.fail(e.getMessage());
        }
    }


    @RequestMapping("/execute-test-plan")
    @ResponseBody
    public SugarResponse<ConcurrentLinkedDeque<SampleEvent>> executeTestPlan(@RequestBody JMeterExecutionVO executionVO){
        try {
            ConcurrentLinkedDeque<SampleEvent> payload = jMeterService.executing(executionVO);
            return SugarResponse.success(payload, "");
        } catch (Exception e){
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }

    @RequestMapping("/execute-test-plan-start")
    @ResponseBody
    public SugarResponse<String> startExecuteTestPlan(@RequestBody JMeterExecutionVO executionVO){
        try {
            jMeterService.executing(executionVO);
            return SugarResponse.success("Done.", "");
        } catch (Exception e){
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/execute-test-plan-stop")
    @ResponseBody
    public SugarResponse<String> stopExecuteTestPlan(String executorId){
        try {
            jMeterService.stopExecuting(executorId);
            return SugarResponse.success("测试计划执行已停止", "");
        } catch (JMeterExecutionException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
