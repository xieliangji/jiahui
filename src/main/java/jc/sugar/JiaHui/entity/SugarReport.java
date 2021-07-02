package jc.sugar.JiaHui.entity;

import org.apache.jmeter.samplers.SampleResult;

import java.util.Date;
import java.util.List;

/**
 * @Code 谢良基 2021/7/2
 */
public class SugarReport {

    private Integer id;


    private String name;


    private Integer jmxId;


    private Date startTime;


    private Date endTime;


    private Date createTime;


    private SugarJMX jmx;


    private Integer status;


    private String reportFile;

    public SugarReport(){}
}
