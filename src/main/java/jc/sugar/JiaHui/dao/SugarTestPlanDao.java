package jc.sugar.JiaHui.dao;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarTestPlan;
import jc.sugar.JiaHui.entity.query.TestPlanQuery;

import java.util.List;

/**
 * @Code 谢良基 2021/7/5
 */
public interface SugarTestPlanDao {


    Integer saveTestPlan(SugarTestPlan testPlan) throws Exception;


    Page<SugarTestPlan> fetchTestPlan(TestPlanQuery query) throws Exception;


    SugarTestPlan fetchTestPlanById(Integer id) throws Exception;


    Integer updateTestPlanById(SugarTestPlan testPlan) throws Exception;


    Integer deleteTestPlanById(Integer id) throws Exception;

    List<SugarTestPlan> fetchTestPlansByAccountId(Integer accountId) throws Exception;
}
