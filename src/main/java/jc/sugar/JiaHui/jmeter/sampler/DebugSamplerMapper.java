package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.JMeterElement;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.AbstractJMeterElementMapper;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import org.apache.jmeter.sampler.DebugSampler;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;

@JMeterElementMapperFor(value = JMeterElementType.DebugSampler, testGuiClass = JMeterElement.DebugSampler)
public class DebugSamplerMapper extends AbstractJMeterElementMapper<DebugSampler> {
    public static final String WEB_DISPLAY_JMETER_PROPERTIES = "displayJMeterProperties";

    public static final String WEB_DISPLAY_JMETER_VARIABLES = "displayJMeterVariables";

    public static final String WEB_DISPLAY_SYSTEM_PROPERTIES = "displaySystemProperties";

    private DebugSamplerMapper(DebugSampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public DebugSamplerMapper(Map<String, Object> attributes){
        this(new DebugSampler(), attributes);
    }

    public DebugSamplerMapper(DebugSampler element){
        this(element, new HashMap<>());
    }

    @Override
    public DebugSampler fromAttributes() {
        element.setProperty(WEB_DISPLAY_JMETER_PROPERTIES, getBoolean(attributes.get(WEB_DISPLAY_JMETER_PROPERTIES)));
        element.setProperty(WEB_DISPLAY_JMETER_VARIABLES, getBoolean(attributes.get(WEB_DISPLAY_JMETER_VARIABLES)));
        element.setProperty(WEB_DISPLAY_SYSTEM_PROPERTIES, getBoolean(attributes.get(WEB_DISPLAY_SYSTEM_PROPERTIES)));

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_DISPLAY_JMETER_PROPERTIES, element.getPropertyAsBoolean(WEB_DISPLAY_JMETER_PROPERTIES));
        attributes.put(WEB_DISPLAY_JMETER_VARIABLES, element.getPropertyAsBoolean(WEB_DISPLAY_JMETER_VARIABLES));
        attributes.put(WEB_DISPLAY_SYSTEM_PROPERTIES, element.getPropertyAsBoolean(WEB_DISPLAY_SYSTEM_PROPERTIES));
        return attributes;
    }
}
