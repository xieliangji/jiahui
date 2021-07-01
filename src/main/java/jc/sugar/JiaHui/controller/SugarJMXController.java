package jc.sugar.JiaHui.controller;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.dto.SugarJMXDTO;
import jc.sugar.JiaHui.entity.vo.JMXQueryVO;
import jc.sugar.JiaHui.entity.vo.JMXSaveVO;
import jc.sugar.JiaHui.exception.SugarJMXException;
import jc.sugar.JiaHui.service.SugarJMXService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Code 谢良基 2021/7/1
 */
@RequestMapping("/sugar-jmx")
@RestController
public class SugarJMXController {

    private final SugarJMXService jmxService;

    public SugarJMXController(SugarJMXService jmxService){
        this.jmxService = jmxService;
    }


    @RequestMapping("/save")
    @ResponseBody
    public SugarResponse<SugarJMXDTO> saveJMX(@RequestBody JMXSaveVO saveVO){
        try {
            SugarJMXDTO payload = jmxService.saveJMX(saveVO);
            return SugarResponse.success(payload, "");
        } catch (SugarJMXException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/query")
    @ResponseBody
    public SugarResponse<Page<SugarJMXDTO>> queryJMX(@RequestBody JMXQueryVO queryVO){

        try {
            Page<SugarJMXDTO> payload = jmxService.queryJMX(queryVO);
            return SugarResponse.success(payload, "");
        } catch (SugarJMXException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, "");
        }

    }
}
