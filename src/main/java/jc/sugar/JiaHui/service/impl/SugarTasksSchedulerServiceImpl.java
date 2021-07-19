package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.dao.SugarTaskDao;
import jc.sugar.JiaHui.entity.SugarTask;
import jc.sugar.JiaHui.exception.SugarTaskException;
import jc.sugar.JiaHui.service.SugarTasksSchedulerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Code 谢良基 2021/7/19
 */
@Service
public class SugarTasksSchedulerServiceImpl implements SugarTasksSchedulerService {
    private static final Logger log = LogManager.getLogger(SugarTasksSchedulerServiceImpl.class);

    private static final String JOB_KEY_PREFIX = "测试计划执行定时任务-";

    private static final String JOB_GROUP_NAME = "测试计划执行定时任务组";

    private static final String TRIGGER_PREFIX = "测试计划定时任务触发器-";

    private final Scheduler scheduler;

    private final SugarTaskDao taskDao;

    public SugarTasksSchedulerServiceImpl(Scheduler scheduler, SugarTaskDao taskDao){
        this.scheduler = scheduler;
        this.taskDao = taskDao;
    }


    @Override
    public void addSugarTask(SugarTask task) throws SugarTaskException {
        String jobKeyName = JOB_KEY_PREFIX + task.getId();
        String triggerKeyName = TRIGGER_PREFIX + task.getId();
        JobDetail jobDetail = JobBuilder.newJob(TestPlanJob.class).withIdentity(jobKeyName, JOB_GROUP_NAME).build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerKeyName, JOB_GROUP_NAME)
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(task.getCronExpression()))
                .forJob(jobDetail).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            log.info("添加定时任务 - " + jobKeyName + " 成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }


    @Override
    public void deleteSugarTask(SugarTask task) throws SugarTaskException {
        String jobKeyName = JOB_KEY_PREFIX + task.getId();
        String triggerKeyName = TRIGGER_PREFIX + task.getId();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerKeyName, JOB_GROUP_NAME);
        JobKey jobKey = JobKey.jobKey(jobKeyName, JOB_GROUP_NAME);

        try {
            Trigger taskTrigger = scheduler.getTrigger(triggerKey);
            if(taskTrigger == null){
                return;
            }
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobKey);
            log.info("删除定时任务 - " + jobKeyName + " 成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new SugarTaskException("删除定时任务失败: " + e.getMessage());
        }
    }

    @Override
    public void enableSugarTask(SugarTask task) throws SugarTaskException {
        String jobKeyName = JOB_KEY_PREFIX + task.getId();
        JobKey taskJobKey = JobKey.jobKey(jobKeyName, JOB_GROUP_NAME);
        try {
            scheduler.resumeJob(taskJobKey);
            log.info("恢复（启用）定时任务 - " + jobKeyName + " 成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new SugarTaskException("启用定时任务失败: " + e.getMessage());
        }
    }

    @Override
    public void disableSugarTask(SugarTask task) throws SugarTaskException {
        String jobKeyName = JOB_KEY_PREFIX + task.getId();
        JobKey taskJobKey = JobKey.jobKey(jobKeyName, JOB_GROUP_NAME);
        try {
            scheduler.pauseJob(taskJobKey);
            log.info("暂停（禁用）定时任务 - " + jobKeyName + " 成功");
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new SugarTaskException("禁用定时任务失败: " + e.getMessage());
        }
    }

    @Override
    public void updateSugarTaskCron(SugarTask task) throws SugarTaskException {
        String triggerKeyName = TRIGGER_PREFIX + task.getId();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerKeyName, JOB_GROUP_NAME);

        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if(trigger != null){
                String oldCronExpr = trigger.getCronExpression();
                if(!oldCronExpr.equals(task.getCronExpression())){
                    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCronExpression());
                    trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
                    scheduler.rescheduleJob(triggerKey, trigger);
                    scheduler.resumeTrigger(triggerKey);
                    log.info("更新定时任务 - " + triggerKeyName + " 成功");
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void loadSugarTasks() throws SugarTaskException {
        try {
            List<SugarTask> allEnableTasks = taskDao.fetchEnableSugarIdName();
            for(SugarTask task: allEnableTasks){
                addSugarTask(task);
            }
            log.info("加载定时任务完成");
        } catch (Exception e) {
            e.printStackTrace();
            throw new SugarTaskException(e);
        }
    }
}
