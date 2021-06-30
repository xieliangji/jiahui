package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.entity.vo.JMeterExecutionVO;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterExecutionException;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterTestElementMapperException;
import org.apache.jmeter.samplers.SampleEvent;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/6/28
 */
public interface SugarJMeterService {

    ConcurrentLinkedDeque<SampleEvent> executing(JMeterExecutionVO executionVO) throws JMeterTestElementMapperException, JMeterExecutionException;


    void stopExecuting(String executorId) throws JMeterExecutionException;
}
