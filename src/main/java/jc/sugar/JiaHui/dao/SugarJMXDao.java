package jc.sugar.JiaHui.dao;

import com.github.pagehelper.Page;
import jc.sugar.JiaHui.entity.SugarJMX;
import jc.sugar.JiaHui.entity.query.JMXQuery;

/**
 * 2021/5/25 11:48
 * Code by 谢良基
 */
public interface SugarJMXDao {

    Integer saveJmx(SugarJMX sugarJMX) throws Exception;


    Page<SugarJMX> queryJmx(JMXQuery jmxQuery) throws Exception;


    Integer updateJmx(SugarJMX sugarJMX) throws Exception;


    SugarJMX fetchJmxById(Integer id) throws Exception;


    Integer deleteJmxById(Integer id) throws Exception;
}
