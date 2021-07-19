package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.entity.SugarTask;
import jc.sugar.JiaHui.exception.SugarTaskException;

/**
 * @Code 谢良基 2021/7/19
 */
public interface SugarTasksSchedulerService {

    void addSugarTask(SugarTask task) throws SugarTaskException;


    void deleteSugarTask(SugarTask task) throws SugarTaskException;


    void enableSugarTask(SugarTask task) throws SugarTaskException;


    void disableSugarTask(SugarTask task) throws SugarTaskException;


    void updateSugarTaskCron(SugarTask task) throws SugarTaskException;


    void loadSugarTasks() throws SugarTaskException;
}
