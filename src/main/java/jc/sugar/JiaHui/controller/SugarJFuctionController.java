package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.entity.SugarJFunction;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.jmeter.function.JMeterFunctionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2021/5/26 10:46
 * Code by 谢良基
 */
@RestController
@RequestMapping("/sugar/function")
public class SugarJFuctionController {


    @RequestMapping("/list")
    @ResponseBody
    public SugarResponse<List<SugarJFunction>> list(){
        return SugarResponse.success(JMeterFunctionUtil.getSugarJFunctions(), "");
    }
}
