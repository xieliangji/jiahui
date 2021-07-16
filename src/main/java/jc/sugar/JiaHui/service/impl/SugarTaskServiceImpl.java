package jc.sugar.JiaHui.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.dao.SugarTaskDao;
import jc.sugar.JiaHui.entity.SugarTask;
import jc.sugar.JiaHui.entity.dto.SugarTaskDTO;
import jc.sugar.JiaHui.entity.query.TaskQuery;
import jc.sugar.JiaHui.entity.vo.TaskQueryVO;
import jc.sugar.JiaHui.entity.vo.TaskSaveVO;
import jc.sugar.JiaHui.entity.vo.TaskUpdateVO;
import jc.sugar.JiaHui.exception.SugarTaskException;
import jc.sugar.JiaHui.service.SugarTaskService;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * @Code 谢良基 2021/7/16
 */
@Service
public class SugarTaskServiceImpl implements SugarTaskService {

    private final SugarTaskDao taskDao;


    public SugarTaskServiceImpl(SugarTaskDao taskDao){
        this.taskDao = taskDao;
    }

    @Override
    public SugarTaskDTO saveTask(TaskSaveVO taskSaveVO) throws SugarTaskException {
        if(StringUtils.isEmpty(taskSaveVO.getName())){
            throw new SugarTaskException("定时任务名称不能为空");
        }
        if(StringUtils.isEmpty(taskSaveVO.getCronExpression())){
            throw new SugarTaskException("cron表达式不能为空");
        }
        if(taskSaveVO.getTaskStatus() == null){
            throw new SugarTaskException("定时任务状态不能为空");
        }
        if(taskSaveVO.getCreatorId() == null){
            throw new SugarTaskException("定时任务创建人不能为空");
        }
        if(taskSaveVO.getTestPlanId() == null){
            throw new SugarTaskException("测试计划不能为空");
        }
        try {
            new CronExpression(taskSaveVO.getCronExpression());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new SugarTaskException(e.getMessage());
        }

        SugarTask task = new SugarTask();
        task.setName(taskSaveVO.getName());
        task.setTestPlanId(taskSaveVO.getTestPlanId());
        task.setTaskStatus(taskSaveVO.getTaskStatus());
        task.setCronExpression(taskSaveVO.getCronExpression());
        task.setRemark(taskSaveVO.getRemark());
        task.setCreatorId(taskSaveVO.getCreatorId());
        try {
            taskDao.saveTask(task);
            task = taskDao.fetchTaskById(task.getId());
            SugarTaskDTO taskDTO = new SugarTaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setName(task.getName());
            taskDTO.setTestPlanId(task.getTestPlanId());
            taskDTO.setTestPlanName(task.getTestPlan().getName());
            taskDTO.setTaskStatus(task.getTaskStatus());
            taskDTO.setCronExpression(task.getCronExpression());
            taskDTO.setRemark(task.getRemark());
            taskDTO.setCreatorId(task.getCreatorId());
            taskDTO.setCreatorName(task.getCreator().getUsername());
            taskDTO.setCreateTime(task.getCreateTime());
            return taskDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }

    @Override
    public SugarTaskDTO updateTask(TaskUpdateVO taskUpdateVO) throws SugarTaskException {
        if(taskUpdateVO.getId() == null){
            throw new SugarTaskException("未指定定时任务ID");
        }
        if(StringUtils.isEmpty(taskUpdateVO.getName())){
            throw new SugarTaskException("定时任务名称不能为空");
        }
        if(taskUpdateVO.getTaskStatus() != 0 && taskUpdateVO.getTaskStatus() != 1){
            throw new SugarTaskException("定时任务装填非法值" + taskUpdateVO.getTaskStatus());
        }
        if(taskUpdateVO.getTestPlanId() == null){
            throw new SugarTaskException("定时任务关联测试计划不能为空");
        }
        if(taskUpdateVO.getUpdaterId() == null){
            throw new SugarTaskException("定时任务更新人ID不能为空");
        }
        if(StringUtils.isEmpty(taskUpdateVO.getCronExpression())){
            throw new SugarTaskException("定时任务cron表达式不能为空");
        }
        try {
            new CronExpression(taskUpdateVO.getCronExpression());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new SugarTaskException(e.getMessage());
        }

        SugarTask task = new SugarTask();
        task.setId(taskUpdateVO.getId());
        task.setName(taskUpdateVO.getName());
        task.setTestPlanId(taskUpdateVO.getTestPlanId());
        task.setCronExpression(taskUpdateVO.getCronExpression());
        task.setRemark(taskUpdateVO.getRemark());
        task.setTaskStatus(taskUpdateVO.getTaskStatus());
        task.setUpdaterId(taskUpdateVO.getUpdaterId());
        try {
            taskDao.updateTask(task);
            task = taskDao.fetchTaskById(task.getId());
            SugarTaskDTO taskDTO = new SugarTaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setName(task.getName());
            taskDTO.setTestPlanId(task.getTestPlanId());
            taskDTO.setTestPlanName(task.getTestPlan().getName());
            taskDTO.setTaskStatus(task.getTaskStatus());
            taskDTO.setCronExpression(task.getCronExpression());
            taskDTO.setRemark(task.getRemark());
            taskDTO.setCreatorId(task.getCreatorId());
            taskDTO.setCreatorName(task.getCreator().getUsername());
            taskDTO.setCreateTime(task.getCreateTime());
            taskDTO.setUpdaterId(task.getUpdaterId());
            taskDTO.setUpdaterName(task.getUpdater().getUsername());
            taskDTO.setUpdateTime(task.getUpdateTime());
            return taskDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }

    @Override
    public Boolean updateTaskStatus(Integer id, SugarTask.TaskStatus status) throws SugarTaskException {
        if(id == null){
            return true;
        }
        SugarTask task = new SugarTask();
        task.setId(id);
        if(status == SugarTask.TaskStatus.ENABLED){
            task.setTaskStatus(1);
        } else {
            task.setTaskStatus(0);
        }
        try {
            taskDao.updateTask(task);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }

    @Override
    public Boolean deleteTask(Integer id) throws SugarTaskException {
        if(id == null){
            return true;
        }
        try {
            return taskDao.deleteTask(id) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }

    @Override
    public PageInfo<SugarTaskDTO> queryTasks(TaskQueryVO taskQueryVO) throws SugarTaskException {
        if(taskQueryVO.getAccountId() == null){
            throw new SugarTaskException("当前用户ID不能为空");
        }
        if(taskQueryVO.getPageNum() == null || taskQueryVO.getPageSize() == null){
            PageHelper.startPage(1, 10);
        } else {
            PageHelper.startPage(taskQueryVO.getPageNum(), taskQueryVO.getPageSize());
        }

        TaskQuery query = new TaskQuery();
        query.setAccountId(taskQueryVO.getAccountId());
        query.setName(taskQueryVO.getName());
        if(taskQueryVO.getTaskStatus() == 0 || taskQueryVO.getTaskStatus() == 1){
            query.setTaskStatus(taskQueryVO.getTaskStatus());
        }
        query.setTestPlanName(taskQueryVO.getTestPlanName());
        query.setCreatorName(taskQueryVO.getCreatorName());
        query.setCreateStartTime(taskQueryVO.getCreateStartTime());
        query.setCreateEndTime(taskQueryVO.getCreateEndTime());

        try {
            Page<SugarTask> tasks = taskDao.queryTask(query);
            Page<SugarTaskDTO> taskDTOS = new Page<>();
            taskDTOS.setTotal(tasks.getTotal());
            taskDTOS.setPageSize(tasks.getPageSize());
            taskDTOS.setPageNum(tasks.getPageNum());

            for(SugarTask task: tasks){
                SugarTaskDTO taskDTO = new SugarTaskDTO();
                taskDTO.setId(task.getId());
                taskDTO.setName(task.getName());
                taskDTO.setTestPlanId(task.getTestPlanId());
                taskDTO.setTestPlanName(task.getTestPlan().getName());
                taskDTO.setTaskStatus(task.getTaskStatus());
                taskDTO.setCronExpression(task.getCronExpression());
                taskDTO.setRemark(task.getRemark());
                taskDTO.setCreatorId(task.getCreatorId());
                taskDTO.setCreatorName(task.getCreator().getUsername());
                taskDTO.setCreateTime(task.getCreateTime());
                if(task.getUpdater() != null){
                    taskDTO.setUpdaterId(task.getUpdaterId());
                    taskDTO.setUpdaterName(task.getUpdater().getUsername());
                    taskDTO.setUpdateTime(task.getUpdateTime());
                }
                taskDTOS.add(taskDTO);
            }
            return taskDTOS.toPageInfo();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }

    @Override
    public SugarTaskDTO fetchTask(Integer id) throws SugarTaskException {
        return null;
    }
}
