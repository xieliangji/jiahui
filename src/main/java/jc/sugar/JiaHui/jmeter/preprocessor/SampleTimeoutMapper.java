package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.modifiers.SampleTimeout;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.SampleTimeout, testGuiClass = JMeterElement.SampleTimeout)
public class SampleTimeoutMapper extends AbstractJMeterElementMapper<SampleTimeout> {

    public static final String WEB_TIMEOUT = "timeout";

    private SampleTimeoutMapper(SampleTimeout element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public SampleTimeoutMapper(Map<String, Object> attributes){
        this(new SampleTimeout(), attributes);
    }

    public SampleTimeoutMapper(SampleTimeout element){
        this(element, new HashMap<>());
    }

    @Override
    public SampleTimeout fromAttributes() {
        element.setTimeout(getString(attributes.get(WEB_TIMEOUT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.SampleTimeout);

        attributes.put(WEB_TIMEOUT, element.getTimeout());
        return attributes;
    }
}
