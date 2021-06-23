package jc.sugar.JiaHui.dao;

import jc.sugar.JiaHui.entity.SugarProjectMember;

import java.util.List;

/**
 * 2021/5/25 11:48
 * Code by 谢良基
 */
public interface SugarProjectMemberDao {

    Integer saveProjectMember(List<SugarProjectMember> list) throws Exception;
}
