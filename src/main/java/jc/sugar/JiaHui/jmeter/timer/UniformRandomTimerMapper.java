package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.UniformRandomTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.UniformRandomTimer, testGuiClass = JMeterElement.UniformRandomTimer)
public class UniformRandomTimerMapper extends JMeterElementMapperRoot<UniformRandomTimer> {

    public static final String WEB_DELAY = "delay";

    public static final String WEB_RANGE = "range";

    private UniformRandomTimerMapper(UniformRandomTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public UniformRandomTimerMapper(Map<String, Object> attributes){
        this(new UniformRandomTimer(), attributes);
    }

    public UniformRandomTimerMapper(UniformRandomTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public UniformRandomTimer fromAttributes() {
        element.setDelay(getString(attributes.get(WEB_DELAY)));
        element.setRange(getString(attributes.get(WEB_RANGE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.UniformRandomTimer);

        attributes.put(WEB_DELAY, element.getDelay());
        attributes.put(WEB_RANGE, element.getRange());

        return attributes;
    }
}
