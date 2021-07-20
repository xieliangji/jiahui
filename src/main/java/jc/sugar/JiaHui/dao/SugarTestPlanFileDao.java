package jc.sugar.JiaHui.dao;

import jc.sugar.JiaHui.entity.SugarTestPlanFile;

/**
 * @Code 谢良基 2021/7/19
 */
public interface SugarTestPlanFileDao {

    Integer saveFile(SugarTestPlanFile file) throws Exception;


    Integer deleteFile(Integer id) throws Exception;
}
