package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.GaussianRandomTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.GaussianRandomTimer, testGuiClass = JMeterElement.GaussianRandomTimer)
public class GaussianRandomTimerMapper extends JMeterElementMapperRoot<GaussianRandomTimer> {

    public static final String WEB_DELAY = "delay";

    public static final String WEB_RANGE = "range";

    private GaussianRandomTimerMapper(GaussianRandomTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public GaussianRandomTimerMapper(Map<String, Object> attributes){
        this(new GaussianRandomTimer(), attributes);
    }

    public GaussianRandomTimerMapper(GaussianRandomTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public GaussianRandomTimer fromAttributes() {
        element.setProperty(WEB_DELAY, getString(attributes.get(WEB_DELAY)));
        element.setProperty(WEB_RANGE, getString(attributes.get(WEB_RANGE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.GaussianRandomTimer);

        attributes.put(WEB_RANGE, element.getPropertyAsString(WEB_RANGE));
        attributes.put(WEB_DELAY, element.getPropertyAsString(WEB_DELAY));
        return attributes;
    }
}
