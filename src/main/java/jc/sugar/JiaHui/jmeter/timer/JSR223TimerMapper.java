package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import jc.sugar.JiaHui.jmeter.common.JSR223ElementMapper;
import org.apache.jmeter.timers.JSR223Timer;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(JMeterElementType.JSR223Timer)
public class JSR223TimerMapper extends JSR223ElementMapper<JSR223Timer> {
    private JSR223TimerMapper(JSR223Timer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSR223TimerMapper(Map<String, Object> attributes){
        this(new JSR223Timer(), attributes);
    }

    public JSR223TimerMapper(JSR223Timer element){
        this(element, new HashMap<>());
    }

    @Override
    public JSR223Timer fromAttributes() {
        setJsr223Element(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.JSR223Timer);
        setJsr223Attributes(attributes, element);
        return attributes;
    }
}
