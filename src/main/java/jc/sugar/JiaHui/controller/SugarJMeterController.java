package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.entity.SugarJFunction;
import jc.sugar.JiaHui.entity.SugarJFunctionResult;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.jmeter.function.JMeterFunctionUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Code 谢良基 2021/6/22
 */
@RestController
@RequestMapping("/sugar-jmeter")
public class SugarJMeterController {

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
    public SugarResponse<SugarJFunctionResult> executeJMeterFunction(@RequestBody SugarJFunction jmeterFunction){
        try {
            SugarJFunctionResult functionCallResult = JMeterFunctionUtil.execute(jmeterFunction);
            return SugarResponse.success(functionCallResult, "");
        } catch (Exception e){
            e.printStackTrace();
            return SugarResponse.fail(e.getMessage());
        }
    }

}
