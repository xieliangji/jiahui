package jc.sugar.JiaHui.service.impl;

import jc.sugar.JiaHui.entity.SugarJMeterRuntimeResultCollector;
import jc.sugar.JiaHui.entity.vo.JMeterExecutionVO;
import jc.sugar.JiaHui.jmeter.JMeterHashTreeUtil;
import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import jc.sugar.JiaHui.jmeter.SugarJMeterContext;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterExecutionException;
import jc.sugar.JiaHui.jmeter.exceptions.JMeterTestElementMapperException;
import jc.sugar.JiaHui.service.SugarJMeterSampleEventWebSocketService;
import jc.sugar.JiaHui.service.SugarJMeterService;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jorphan.collections.HashTree;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/6/28
 */
@Service
public class SugarJMeterServiceImpl implements SugarJMeterService {

    private final SugarJMeterSampleEventWebSocketService webSocketService;

    public SugarJMeterServiceImpl(SugarJMeterSampleEventWebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }


    @Override
    public ConcurrentLinkedDeque<SampleEvent> executing(JMeterExecutionVO executionVO) throws JMeterTestElementMapperException, JMeterExecutionException {
        try {
            SugarJMeterContext.resetSugarJMeterContextClassLoader();
        } catch (IOException e) {
            e.printStackTrace();
            throw new JMeterExecutionException("类加载器重置失败！");
        }
        JMeterInitializer.initialize();
        StandardJMeterEngine engine = JMeterInitializer.EXECUTORS.get(executionVO.getExecutorId());
        if(engine == null){
            engine = new StandardJMeterEngine();
            JMeterInitializer.EXECUTORS.put(executionVO.getExecutorId(), engine);
        }

        if(engine.isActive()){
            throw new JMeterExecutionException("当前已有测试计划在执行，请稍后");
        }

        HashTree testPlanHashTree = JMeterHashTreeUtil.toHashTree(executionVO.getTestPlanList());
        SugarJMeterRuntimeResultCollector resultCollector = new SugarJMeterRuntimeResultCollector(webSocketService, executionVO.getExecutorId());
        Object testElement = testPlanHashTree.getArray()[0];
        if(testElement instanceof TestPlan){
            testPlanHashTree.add(testElement, resultCollector);
        } else {
            throw new JMeterExecutionException("There's no TestPlan in TestPlanTree. - " + executionVO);
        }
        JMeter.convertSubTree(testPlanHashTree, false);
        engine.configure(testPlanHashTree);
        engine.run();

        ConcurrentLinkedDeque<SampleEvent> sampleEvents = resultCollector.getSampleEvents();

        return sampleEvents;
    }

    @Override
    public void stopExecuting(String executorId) throws JMeterExecutionException {
        StandardJMeterEngine engine = JMeterInitializer.EXECUTORS.get(executorId);
        if(engine != null){
            engine.stopTest();
            JMeterInitializer.EXECUTORS.remove(executorId);
        } else {
            throw new JMeterExecutionException("没有测试计划在执行");
        }
    }

}
