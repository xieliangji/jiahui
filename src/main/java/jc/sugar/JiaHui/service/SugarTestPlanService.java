package jc.sugar.JiaHui.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import jc.sugar.JiaHui.entity.dto.SugarTestPlanDTO;
import jc.sugar.JiaHui.entity.vo.TestPlanExecuteVO;
import jc.sugar.JiaHui.entity.vo.TestPlanQueryVO;
import jc.sugar.JiaHui.entity.vo.TestPlanSaveVO;
import jc.sugar.JiaHui.entity.vo.TestPlanUpdateVO;
import jc.sugar.JiaHui.exception.SugarJMXException;

import java.util.List;

/**
 * @Code 谢良基 2021/7/5
 */
public interface SugarTestPlanService {

    SugarTestPlanDTO saveTestPlan(TestPlanSaveVO testPlanSaveVO) throws SugarJMXException, JsonProcessingException;


    SugarTestPlanDTO updateTestPlan(TestPlanUpdateVO testPlanUpdateVO) throws SugarJMXException, JsonProcessingException;


    PageInfo<SugarTestPlanDTO> queryTestPlan(TestPlanQueryVO testPlanQueryVO) throws SugarJMXException;


    SugarTestPlanDTO queryTestPlanById(Integer id) throws SugarJMXException;


    Integer deleteTestPlanById(Integer id) throws SugarJMXException;


    Boolean executeTestPlan(TestPlanExecuteVO testPlanExecuteVO) throws SugarJMXException;


    List<SugarTestPlanDTO> fetchTestPlansByAccountId(Integer accountId) throws SugarJMXException;
}
