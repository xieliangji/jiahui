package jc.sugar.JiaHui.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jc.sugar.JiaHui.entity.SugarJMeterSampleEvent;
import jc.sugar.JiaHui.exception.SugarJMeterException;
import jc.sugar.JiaHui.service.SugarJMeterSampleEventWebSocketService;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Code 谢良基 2021/6/29
 */
@Service
@ServerEndpoint(value = "/sample-event-websocket/{executorId}")
public class SugarJMeterSampleEventWebSocketServiceImpl implements SugarJMeterSampleEventWebSocketService {

    private static final ConcurrentHashMap<String, Session> webSocketSessionPool = new ConcurrentHashMap<>();

    private final Logger logger = LogManager.getLogger(SugarJMeterSampleEventWebSocketServiceImpl.class);

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "executorId") String executorId){
        webSocketSessionPool.put(executorId, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam(value = "executorId") String executorId){
        webSocketSessionPool.remove(executorId);
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam(value = "executorId") String executorId){
        // 暂不接受web端关于SampleEvent相关的消息，web端只接受服务端推送的SampleEvent结果
    }

    @OnError
    public void onError(Session session, Throwable error){
        logger.error(error.getMessage());
        error.printStackTrace();
    }

    @Override
    public void sendSampleEvent(String executorId, SugarJMeterSampleEvent sampleEvent) throws SugarJMeterException {
        Session session = webSocketSessionPool.get(executorId);
        if(session == null){
            throw new SugarJMeterException("WebSocket会话不存在");
        }
        try {
            session.getBasicRemote().sendText(new ObjectMapper().writeValueAsString(sampleEvent));
        } catch (IOException e) {
            e.printStackTrace();
            throw new SugarJMeterException(e);
        }
    }
}
