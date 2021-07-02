package jc.sugar.JiaHui.entity;

import jc.sugar.JiaHui.exception.SugarJMeterException;
import jc.sugar.JiaHui.service.SugarJMeterSampleEventWebSocketService;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleResult;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Code 谢良基 2021/6/28
 *
 * 执行测试计划逻辑：
 * 1、每次测试计划执行都会创建一个StandardJMeterEngine，每次执行结束后都会销毁这个StandardJMeterEngine
 * 2、原测试计划的监听器元素会被删除，取而代之的是往原测试计划中注入一个SugarJMeterResultCollector
 * 3、SugarJMeterResultCollector会在有SampleEvent时，通过WebSocket服务向前端发送SampleEvent
 */
public class SugarJMeterResultCollector extends ResultCollector {

    private final ConcurrentLinkedDeque<SampleEvent> sampleEvents = new ConcurrentLinkedDeque<>();

    private SugarJMeterSampleEventWebSocketService webSocketService;

    private String executorId;

    public SugarJMeterResultCollector(){}

    public SugarJMeterResultCollector(SugarJMeterSampleEventWebSocketService webSocketService, String executorId){
        this.webSocketService = webSocketService;
        this.executorId = executorId;
    }


    @Override
    public void sampleOccurred(SampleEvent event){
        super.sampleOccurred(event);

        // 消除循环引用
        setSampleResultParentNull(event.getResult());

        if(webSocketService != null){
            try {
                webSocketService.sendSampleEvent(executorId, new SugarJMeterSamplerResult(event.getResult()));
            } catch (SugarJMeterException e) {
                e.printStackTrace();
            }
        }
        sampleEvents.add(event);
    }


    public ConcurrentLinkedDeque<SampleEvent> getSampleEvents(){
        return sampleEvents;
    }


    private void setSampleResultParentNull(SampleResult sampleResult){
        sampleResult.setParent(null);
        SampleResult[] subResults = sampleResult.getSubResults();
        for(SampleResult subResult: subResults){
            setSampleResultParentNull(subResult);
        }
    }


    // 可以做一些报告数据的扩展
}
