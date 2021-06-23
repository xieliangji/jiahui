package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.dto.SugarProjectDto;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.exception.SugarProjectException;
import jc.sugar.JiaHui.service.SugarProjectService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Code 谢良基 2021/6/23
 */
@RestController
@RequestMapping("/sugar-project")
public class SugarProjectController {

    private final SugarProjectService projectService;

    public SugarProjectController(SugarProjectService projectService){
        this.projectService = projectService;
    }


    @RequestMapping("/all")
    @ResponseBody
    public SugarResponse<List<SugarProjectDto>> getAllProjects(Integer accountId){
        try {
            List<SugarProjectDto> payload = projectService.getProjectsOfAccount(accountId);
            return SugarResponse.success(payload, "");
        } catch (SugarProjectException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/save")
    @ResponseBody
    public SugarResponse<SugarProjectDto> saveProject(@RequestBody SugarProjectDto newProject){
        try {
            SugarProjectDto payload = projectService.saveProject(newProject);
            return SugarResponse.success(payload, "");
        } catch (SugarProjectException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
