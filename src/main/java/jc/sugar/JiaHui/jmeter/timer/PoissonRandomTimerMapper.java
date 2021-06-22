package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.PoissonRandomTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.PoissonRandomTimer, testGuiClass = JMeterElement.PoissonRandomTimer)
public class PoissonRandomTimerMapper extends AbstractJMeterElementMapper<PoissonRandomTimer> {

    public static final String WEB_DELAY = "delay";

    public static final String WEB_RANGE = "range";

    private PoissonRandomTimerMapper(PoissonRandomTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public PoissonRandomTimerMapper(Map<String, Object> attributes){
        this(new PoissonRandomTimer(), attributes);
    }

    public PoissonRandomTimerMapper(PoissonRandomTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public PoissonRandomTimer fromAttributes() {
        element.setProperty(WEB_DELAY, getString(attributes.get(WEB_DELAY)));
        element.setProperty(WEB_RANGE, getString(attributes.get(WEB_RANGE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.PoissonRandomTimer);

        attributes.put(WEB_DELAY, element.getPropertyAsString(WEB_DELAY));
        attributes.put(WEB_RANGE, element.getPropertyAsString(WEB_RANGE));
        return attributes;
    }
}
