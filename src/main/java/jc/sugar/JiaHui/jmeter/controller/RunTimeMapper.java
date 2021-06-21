package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.RunTime;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getLong;

@JMeterElementMapperFor(value = JMeterElementType.RunTime, testGuiClass = JMeterElement.RunTime)
public class RunTimeMapper extends JMeterElementMapperRoot<RunTime> {
    public static final String WEB_SECONDS = "seconds";

    private RunTimeMapper(RunTime element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public RunTimeMapper(Map<String, Object> attributes){
        this(new RunTime(), attributes);
    }

    public RunTimeMapper(RunTime element){
        this(element, new HashMap<>());
    }

    @Override
    public RunTime fromAttributes() {
        element.setRuntime(getLong(attributes.get(WEB_SECONDS)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.RunTime);
        attributes.put(WEB_SECONDS, element.getRuntime());
        return attributes;
    }
}
