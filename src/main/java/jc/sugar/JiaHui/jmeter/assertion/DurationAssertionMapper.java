package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.DurationAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getLong;

@JMeterElementMapperFor(value = JMeterElementType.DurationAssertion, testGuiClass = JMeterElement.DurationAssertion)
public class DurationAssertionMapper extends AbstractJMeterElementMapper<DurationAssertion> {

    public static final String WEB_DURATION = "duration";

    private DurationAssertionMapper(DurationAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public DurationAssertionMapper(Map<String, Object> attributes){
        this(new DurationAssertion(), attributes);
    }

    public DurationAssertionMapper(DurationAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public DurationAssertion fromAttributes() {
        element.setAllowedDuration(getLong(attributes.get(WEB_DURATION)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.DurationAssertion);
        attributes.put(WEB_DURATION, element.getPropertyAsString(DurationAssertion.DURATION_KEY));
        return attributes;
    }
}
