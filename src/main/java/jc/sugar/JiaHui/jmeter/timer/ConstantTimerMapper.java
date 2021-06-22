package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.ConstantTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.ConstantTimer, testGuiClass = JMeterElement.ConstantTimer)
public class ConstantTimerMapper extends AbstractJMeterElementMapper<ConstantTimer> {

    public static final String WEB_DELAY = "delay";

    private ConstantTimerMapper(ConstantTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ConstantTimerMapper(Map<String, Object> attributes){
        this(new ConstantTimer(), attributes);
    }

    public ConstantTimerMapper(ConstantTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public ConstantTimer fromAttributes() {
        element.setDelay(getString(attributes.get(WEB_DELAY)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.ConstantTimer);

        attributes.put(WEB_DELAY, element.getDelay());
        return attributes;
    }
}
