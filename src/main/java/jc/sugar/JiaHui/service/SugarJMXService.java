package jc.sugar.JiaHui.service;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarJMX;
import jc.sugar.JiaHui.entity.dto.SugarJMXDTO;
import jc.sugar.JiaHui.entity.vo.JMXQueryVO;
import jc.sugar.JiaHui.entity.vo.JMXSaveVO;
import jc.sugar.JiaHui.exception.SugarJMXException;

/**
 * @Code 谢良基 2021/7/1
 */
public interface SugarJMXService {

    SugarJMXDTO saveJMX(JMXSaveVO saveVO) throws SugarJMXException;


    Page<SugarJMXDTO> queryJMX(JMXQueryVO queryVO) throws SugarJMXException;
}
