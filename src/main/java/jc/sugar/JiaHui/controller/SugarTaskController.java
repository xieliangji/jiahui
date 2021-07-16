package jc.sugar.JiaHui.controller;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.SugarResponse;
import jc.sugar.JiaHui.entity.SugarTask;
import jc.sugar.JiaHui.entity.dto.SugarTaskDTO;
import jc.sugar.JiaHui.entity.vo.TaskQueryVO;
import jc.sugar.JiaHui.entity.vo.TaskSaveVO;
import jc.sugar.JiaHui.entity.vo.TaskUpdateVO;
import jc.sugar.JiaHui.exception.SugarTaskException;
import jc.sugar.JiaHui.service.SugarTaskService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Code 谢良基 2021/7/16
 */
@RestController
@RequestMapping("/sugar-task")
public class SugarTaskController {

    private final SugarTaskService taskService;


    public SugarTaskController(SugarTaskService taskService){
        this.taskService = taskService;
    }


    @RequestMapping("/fetch")
    @ResponseBody
    public SugarResponse<SugarTaskDTO> fetchSugarTask(Integer id){


        return null;
    }


    @RequestMapping("/query")
    @ResponseBody
    public SugarResponse<PageInfo<SugarTaskDTO>> query(@RequestBody TaskQueryVO taskQueryVO){
        try {
            PageInfo<SugarTaskDTO> payload = taskService.queryTasks(taskQueryVO);
            return SugarResponse.success(payload, "");
        } catch (SugarTaskException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/save")
    public SugarResponse<SugarTaskDTO> save(@RequestBody TaskSaveVO taskSaveVO){
        try {
            SugarTaskDTO payload = taskService.saveTask(taskSaveVO);
            return SugarResponse.success(payload, "");
        } catch (SugarTaskException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/update")
    public SugarResponse<SugarTaskDTO> update(@RequestBody TaskUpdateVO taskUpdateVO){
        try {
            SugarTaskDTO payload = taskService.updateTask(taskUpdateVO);
            return SugarResponse.success(payload, "");
        } catch (SugarTaskException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/disable")
    public SugarResponse<Boolean> disableTask(Integer id){
        try {
            Boolean payload = taskService.updateTaskStatus(id, SugarTask.TaskStatus.DISABLED);
            return SugarResponse.success(payload, "");
        } catch (SugarTaskException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/enable")
    public SugarResponse<Boolean> enableTask(Integer id){
        try {
            Boolean payload = taskService.updateTaskStatus(id, SugarTask.TaskStatus.ENABLED);
            return SugarResponse.success(payload, "");
        } catch (SugarTaskException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }


    @ResponseBody
    @RequestMapping("/delete")
    public SugarResponse<Boolean> delete(Integer id){
        try {
            Boolean payload = taskService.deleteTask(id);
            return SugarResponse.success(payload, "");
        } catch (SugarTaskException e) {
            e.printStackTrace();
            return new SugarResponse<>(10086, null, e.getMessage());
        }
    }
}
