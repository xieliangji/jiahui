package jc.sugar.JiaHui.dao;

import jc.sugar.JiaHui.entity.SugarProject;

import java.util.List;

/**
 * 2021/5/25 11:48
 * Code by 谢良基
 */
public interface SugarProjectDao {

    List<SugarProject> findProjectByMember(Integer accountId) throws Exception;


    Integer saveProject(SugarProject project) throws Exception;


}
