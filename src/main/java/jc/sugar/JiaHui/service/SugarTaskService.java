package jc.sugar.JiaHui.service;

import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.SugarTask.TaskStatus;
import jc.sugar.JiaHui.entity.dto.SugarTaskDTO;
import jc.sugar.JiaHui.entity.vo.TaskQueryVO;
import jc.sugar.JiaHui.entity.vo.TaskSaveVO;
import jc.sugar.JiaHui.entity.vo.TaskUpdateVO;
import jc.sugar.JiaHui.exception.SugarTaskException;

/**
 * @Code 谢良基 2021/7/16
 */
public interface SugarTaskService {

    SugarTaskDTO saveTask(TaskSaveVO taskSaveVO) throws SugarTaskException;


    SugarTaskDTO updateTask(TaskUpdateVO taskUpdateVO) throws SugarTaskException;


    Boolean updateTaskStatus(Integer id, TaskStatus status) throws SugarTaskException;


    Boolean deleteTask(Integer id) throws SugarTaskException;


    PageInfo<SugarTaskDTO> queryTasks(TaskQueryVO taskQueryVO) throws SugarTaskException;


    SugarTaskDTO fetchTask(Integer id) throws SugarTaskException;
}
