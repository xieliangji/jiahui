package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.SyncTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.SyncTimer, testGuiClass = JMeterElement.SyncTimer)
public class SyncTimerMapper extends JMeterElementMapperRoot<SyncTimer> {

    public static final String WEB_GROUP_SIZE = "groupSize";

    public static final String WEB_TIMEOUT_IN_MS = "timeoutInMs";

    private SyncTimerMapper(SyncTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public SyncTimerMapper(Map<String, Object> attributes){
        this(new SyncTimer(), attributes);
    }

    public SyncTimerMapper(SyncTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public SyncTimer fromAttributes() {
        element.setProperty(WEB_GROUP_SIZE, getString(attributes.get(WEB_GROUP_SIZE)));
        element.setProperty(WEB_TIMEOUT_IN_MS, getString(attributes.get(WEB_TIMEOUT_IN_MS)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.SyncTimer);

        attributes.put(WEB_GROUP_SIZE, element.getPropertyAsString(WEB_GROUP_SIZE));
        attributes.put(WEB_TIMEOUT_IN_MS, element.getPropertyAsString(WEB_TIMEOUT_IN_MS));
        return attributes;
    }
}
