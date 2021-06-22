package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.sampler.TestAction;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getInt;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.TestAction, testGuiClass = JMeterElement.TestAction)
public class TestActionMapper extends AbstractJMeterElementMapper<TestAction> {
    public static final String WEB_ACTION = "action";

    public static final String WEB_TARGET = "target";

    public static final String WEB_DURATION = "duration";

    private TestActionMapper(TestAction element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public TestActionMapper(Map<String, Object> attributes){
        this(new TestAction(), attributes);
    }

    public TestActionMapper(TestAction element){
        this(element, new HashMap<>());
    }

    @Override
    public TestAction fromAttributes() {
        element.setAction(getInt(attributes.get(WEB_ACTION)));
        element.setTarget(getInt(attributes.get(WEB_TARGET)));
        element.setDuration(getString(attributes.get(WEB_DURATION)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.TestAction);

        attributes.put(WEB_ACTION, element.getAction());
        attributes.put(WEB_TARGET, element.getTarget());
        attributes.put(WEB_DURATION, element.getDurationAsString());
        return attributes;
    }
}
