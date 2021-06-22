package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.jmespath.JMESPathAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.JMESPathAssertion, testGuiClass = JMeterElement.JMESPathAssertion)
public class JMESPathAssertionMapper extends JMeterElementMapperRoot<JMESPathAssertion> {

    public static final String WEB_JSON_PATH = "jsonPath";

    public static final String WEB_JSON_VALIDATION = "jsonValidation";

    public static final String WEB_IS_REGEX = "isRegex";

    public static final String WEB_EXPECTED_VALUE = "expectedValue";

    public static final String WEB_EXPECT_NULL = "expectNull";

    public static final String WEB_INVERT = "invert";

    private JMESPathAssertionMapper(JMESPathAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JMESPathAssertionMapper(Map<String, Object> attributes){
        this(new JMESPathAssertion(), attributes);
    }

    public JMESPathAssertionMapper(JMESPathAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public JMESPathAssertion fromAttributes() {
        element.setJmesPath(getString(attributes.get(WEB_JSON_PATH)));
        element.setJsonValidationBool(getBoolean(attributes.get(WEB_JSON_VALIDATION)));
        element.setIsRegex(getBoolean(attributes.get(WEB_IS_REGEX)));
        element.setExpectedValue(getString(attributes.get(WEB_EXPECTED_VALUE)));
        element.setExpectNull(getBoolean(attributes.get(WEB_EXPECT_NULL)));
        element.setInvert(getBoolean(attributes.get(WEB_INVERT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.JMESPathAssertion);

        attributes.put(WEB_JSON_PATH, element.getJmesPath());
        attributes.put(WEB_JSON_VALIDATION, element.isJsonValidationBool());
        attributes.put(WEB_IS_REGEX, element.isUseRegex());
        attributes.put(WEB_EXPECTED_VALUE, element.getExpectedValue());
        attributes.put(WEB_EXPECT_NULL, element.isExpectNull());
        attributes.put(WEB_INVERT, element.isInvert());
        return attributes;
    }
}
