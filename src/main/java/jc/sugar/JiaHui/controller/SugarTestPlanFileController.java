package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.exception.SugarTestPlanFileException;
import jc.sugar.JiaHui.service.SugarTestPlanFileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Code 谢良基 2021/7/19
 */
@RestController
@RequestMapping("/sugar-test-file")
public class SugarTestPlanFileController {

    private final SugarTestPlanFileService fileService;


    public SugarTestPlanFileController(SugarTestPlanFileService fileService){
        this.fileService = fileService;
    }


    @ResponseBody
    @RequestMapping("/upload")
    public SugarResponse<String> uploadTestFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("uploaderId") Integer uploaderId){
        try {
            String payload = fileService.uploadTestPlanFile(multipartFile, uploaderId);
            return SugarResponse.success(payload, "");
        } catch (SugarTestPlanFileException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
