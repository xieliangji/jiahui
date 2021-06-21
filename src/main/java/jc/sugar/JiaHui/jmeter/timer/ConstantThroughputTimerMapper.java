package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.ConstantThroughputTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.ConstantThroughputTimer, testGuiClass = JMeterElement.ConstantThroughputTimer)
public class ConstantThroughputTimerMapper extends JMeterElementMapperRoot<ConstantThroughputTimer> {

    public static final String WEB_CALC_MODE = "calcMode";

    public static final String WEB_THROUGHPUT = "throughput";

    private ConstantThroughputTimerMapper(ConstantThroughputTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ConstantThroughputTimerMapper(Map<String, Object> attributes){
        this(new ConstantThroughputTimer(), attributes);
    }

    public ConstantThroughputTimerMapper(ConstantThroughputTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public ConstantThroughputTimer fromAttributes() {
        element.setProperty(WEB_CALC_MODE, getString(attributes.get(WEB_CALC_MODE)));
        element.setProperty(WEB_THROUGHPUT, getString(attributes.get(WEB_THROUGHPUT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.ConstantThroughputTimer);

        attributes.put(WEB_CALC_MODE, element.getPropertyAsString(WEB_CALC_MODE));
        attributes.put(WEB_THROUGHPUT, element.getPropertyAsString(WEB_THROUGHPUT));
        return attributes;
    }
}
