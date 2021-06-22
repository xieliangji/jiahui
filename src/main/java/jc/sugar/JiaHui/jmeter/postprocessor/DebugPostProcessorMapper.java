package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.DebugPostProcessor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;

@JMeterElementMapperFor(value = JMeterElementType.DebugPostProcessor, testGuiClass = JMeterElement.DebugPostProcessor)
public class DebugPostProcessorMapper extends AbstractJMeterElementMapper<DebugPostProcessor> {

    public static final String WEB_DISPLAY_JMETER_PROPERTIES = "displayJMeterProperties";

    public static final String WEB_DISPLAY_JMETER_VARIABLES = "displayJMeterVariables";

    public static final String WEB_DISPLAY_SAMPLER_PROPERTIES = "displaySamplerProperties";

    public static final String WEB_DISPLAY_SYSTEM_PROPERTIES = "displaySystemProperties";

    private DebugPostProcessorMapper(DebugPostProcessor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public DebugPostProcessorMapper(Map<String, Object> attributes){
        this(new DebugPostProcessor(), attributes);
    }

    public DebugPostProcessorMapper(DebugPostProcessor element){
        this(element, new HashMap<>());
    }

    @Override
    public DebugPostProcessor fromAttributes() {
        element.setProperty(WEB_DISPLAY_JMETER_PROPERTIES, getBoolean(attributes.get(WEB_DISPLAY_JMETER_PROPERTIES)));
        element.setProperty(WEB_DISPLAY_JMETER_VARIABLES, getBoolean(attributes.get(WEB_DISPLAY_JMETER_VARIABLES)));
        element.setProperty(WEB_DISPLAY_SAMPLER_PROPERTIES, getBoolean(attributes.get(WEB_DISPLAY_SAMPLER_PROPERTIES)));
        element.setProperty(WEB_DISPLAY_SYSTEM_PROPERTIES, getBoolean(attributes.get(WEB_DISPLAY_SYSTEM_PROPERTIES)));

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.DebugPostProcessor);

        attributes.put(WEB_DISPLAY_JMETER_PROPERTIES, element.getPropertyAsString(WEB_DISPLAY_JMETER_PROPERTIES));
        attributes.put(WEB_DISPLAY_JMETER_VARIABLES, element.getPropertyAsString(WEB_DISPLAY_JMETER_VARIABLES));
        attributes.put(WEB_DISPLAY_SAMPLER_PROPERTIES, element.getPropertyAsString(WEB_DISPLAY_SAMPLER_PROPERTIES));
        attributes.put(WEB_DISPLAY_SYSTEM_PROPERTIES, element.getPropertyAsString(WEB_DISPLAY_SYSTEM_PROPERTIES));

        return attributes;
    }
}
