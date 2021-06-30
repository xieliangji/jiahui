package jc.sugar.JiaHui.controller;

import jc.sugar.JiaHui.dto.project.SugarProjectDTO;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.vo.ProjectQueryVO;
import jc.sugar.JiaHui.entity.vo.ProjectSaveVO;
import jc.sugar.JiaHui.entity.vo.ProjectUpdateVO;
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


    @RequestMapping("/query")
    @ResponseBody
    public SugarResponse<List<SugarProjectDTO>> fetchProjects(@RequestBody ProjectQueryVO queryVO){
        try {
            List<SugarProjectDTO> payload = projectService.queryProjects(queryVO);
            return SugarResponse.success(payload, "");
        } catch (SugarProjectException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/save")
    @ResponseBody
    public SugarResponse<SugarProjectDTO> saveProject(@RequestBody ProjectSaveVO saveVO){
        try {
            SugarProjectDTO payload = projectService.saveProject(saveVO);
            return SugarResponse.success(payload, "");
        } catch (SugarProjectException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/delete")
    @ResponseBody
    public SugarResponse<Integer> deleteProject(Integer id) {
        try {
            Integer payload = projectService.deleteProject(id);
            return SugarResponse.success(payload, "");
        } catch (SugarProjectException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @RequestMapping("/update")
    @ResponseBody
    public SugarResponse<Integer> updateProject(@RequestBody ProjectUpdateVO updateVO){
        try {
            Integer payload = projectService.updateProject(updateVO);
            return SugarResponse.success(payload, "");
        } catch (SugarProjectException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
