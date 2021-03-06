package jc.sugar.JiaHui.service;

import jc.sugar.JiaHui.entity.SugarJMeterSamplerResult;
import jc.sugar.JiaHui.exception.SugarJMeterException;

/**
 * @Code 谢良基 2021/6/29
 */
public interface SugarJMeterSampleEventWebSocketService {

    void sendSampleEvent(String executorId, SugarJMeterSamplerResult samplerResult) throws SugarJMeterException;
}
