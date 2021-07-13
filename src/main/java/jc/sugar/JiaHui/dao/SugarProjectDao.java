package jc.sugar.JiaHui.dao;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarProject;
import jc.sugar.JiaHui.entity.query.ProjectQuery;

/**
 * 2021/5/25 11:48
 * Code by 谢良基
 */
public interface SugarProjectDao {

    Integer saveProject(SugarProject project) throws Exception;


    Page<SugarProject> queryProject(ProjectQuery query) throws Exception;


    Integer updateProject(SugarProject project) throws Exception;


    Integer deleteProjectById(Integer id) throws Exception;


    SugarProject fetchProjectById(Integer id) throws Exception;
}
