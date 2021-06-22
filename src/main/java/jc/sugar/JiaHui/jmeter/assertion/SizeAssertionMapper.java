package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.SizeAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getInt;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.SizeAssertion, testGuiClass = JMeterElement.SizeAssertion)
public class SizeAssertionMapper extends JMeterElementMapperRoot<SizeAssertion> {

    //+ JMX keys
    public static final String TEST_FIELD = "Assertion.test_field";

    public static final String WEB_TEST_FIELD = "testField";

    public static final String WEB_SIZE = "size";

    public static final String WEB_OPERATOR = "operator";

    private SizeAssertionMapper(SizeAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public SizeAssertionMapper(Map<String, Object> attributes){
        this(new SizeAssertion(), attributes);
    }

    public SizeAssertionMapper(SizeAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public SizeAssertion fromAttributes() {
        element.setProperty(TEST_FIELD, getString(attributes.get(WEB_TEST_FIELD)));
        element.setAllowedSize(getString(attributes.get(WEB_SIZE)));
        element.setCompOper(getInt(attributes.get(WEB_OPERATOR)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.SizeAssertion);

        attributes.put(WEB_TEST_FIELD, element.getTestField());
        attributes.put(WEB_SIZE, element.getAllowedSize());
        attributes.put(WEB_OPERATOR, element.getCompOper());
        return attributes;
    }
}
