package jc.sugar.JiaHui.controller;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.dto.SugarFileDTO;
import jc.sugar.JiaHui.entity.query.FileQuery;
import jc.sugar.JiaHui.entity.vo.FileUpdateVO;
import jc.sugar.JiaHui.exception.SugarFileException;
import jc.sugar.JiaHui.jmeter.SugarJMeterContext;
import jc.sugar.JiaHui.service.SugarFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLClassLoader;

/**
 * @Code 谢良基 2021/7/9
 */
@RestController
@RequestMapping("/sugar-file")
public class SugarFileController {


    private final SugarFileService fileService;


    public SugarFileController(SugarFileService fileService){
        this.fileService = fileService;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public SugarResponse<SugarFileDTO> upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("name") String name,
                                              @RequestParam("fileType") Integer fileType, @RequestParam("remark") String remark, @RequestParam("uploaderId") Integer uploaderId) {
        try {
            SugarFileDTO payload = fileService.upload(multipartFile, name, fileType, remark, uploaderId);
            return SugarResponse.success(payload, "");
        } catch (SugarFileException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/query")
    public SugarResponse<PageInfo<SugarFileDTO>> query(@RequestBody FileQuery fileQuery){
        try {
            PageInfo<SugarFileDTO> payload = fileService.query(fileQuery);
            return SugarResponse.success(payload, "");
        } catch (SugarFileException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/delete")
    public SugarResponse<String> delete(Integer id){
        try {
            fileService.delete(id);
            return SugarResponse.success("删除成功", "");
        } catch (SugarFileException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/update")
    public SugarResponse<Integer> update(@RequestBody FileUpdateVO fileUpdateVO){
        try {
            Integer payload = fileService.update(fileUpdateVO);
            return SugarResponse.success(payload, "");
        } catch (SugarFileException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
