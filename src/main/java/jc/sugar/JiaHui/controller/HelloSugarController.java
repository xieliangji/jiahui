package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.config.SugarProperties;
import jc.sugar.JiaHui.entity.SugarResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/5/25 16:45
 * Code by 谢良基
 */
@RestController
public class HelloSugarController {
    /**
     * 3种依赖注入方式：
     * Field 注入 - 不推荐 （显式注解@Autowired）
     * Constructor 注入 - 组件少时推荐 可以省略 @Autowired
     * Setters 注入 - 组件较多时推荐 （显式注解@Autowired）
     */

    private SugarProperties sugarProperties;


    public HelloSugarController(SugarProperties sugarProperties){
        this.sugarProperties = sugarProperties;
    }

//    @Autowired
//    public void setSugarProperties(SugarProperties sugarProperties){
//        this.sugarProperties = sugarProperties;
//    }

    @ResponseBody
    @RequestMapping(path = "/sugar/properties")
    public SugarResponse<SugarProperties> showProperties(){
        return SugarResponse.success(sugarProperties, "Success");
    }


    @RequestMapping("/sugar/hello")
    public String helloSugar(){
        return "Hello Sugar!";
    }
}
