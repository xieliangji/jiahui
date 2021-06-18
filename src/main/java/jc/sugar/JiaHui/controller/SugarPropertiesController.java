package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.config.SugarProperties;
import jc.sugar.JiaHui.entity.SugarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/5/25 14:09
 * Code by 谢良基
 */
@RestController
public class SugarPropertiesController {

    private final SugarProperties sugarProperties;

    @Autowired
    public SugarPropertiesController(SugarProperties sugarProperties) {
        this.sugarProperties = sugarProperties;
    }


    @ResponseBody
    @RequestMapping(path = "/all")
    public SugarResponse<SugarProperties> allprop(){
        return SugarResponse.success(sugarProperties, "Success");
    }


    @ResponseBody
    @RequestMapping(path = "/hello")
    public SugarResponse<String> hi(){
        return SugarResponse.success("hello", "haha");
    }
}
