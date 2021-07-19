package jc.sugar.JiaHui.dao;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarTask;
import jc.sugar.JiaHui.entity.query.TaskQuery;

import java.util.List;

/**
 * @Code 谢良基 2021/7/16
 */
public interface SugarTaskDao {

    Integer saveTask(SugarTask sugarTask) throws Exception;

    Integer deleteTask(Integer id) throws Exception;

    Integer updateTask(SugarTask task) throws Exception;

    SugarTask fetchTaskById(Integer id) throws Exception;

    Page<SugarTask> queryTask(TaskQuery taskQuery) throws Exception;

    List<SugarTask> fetchEnableSugarIdName() throws Exception;
}
