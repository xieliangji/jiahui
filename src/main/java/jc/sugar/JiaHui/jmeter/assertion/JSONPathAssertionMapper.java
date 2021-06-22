package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.JSONPathAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.JSONPathAssertion, testGuiClass = JMeterElement.JSONPathAssertion)
public class JSONPathAssertionMapper extends JMeterElementMapperRoot<JSONPathAssertion> {

    public static final String WEB_JSON_PATH = "jsonPath";

    public static final String WEB_JSON_VALIDATION = "jsonValidation";

    public static final String WEB_IS_REGEX = "isRegex";

    public static final String WEB_EXPECTED_VALUE = "expectedValue";

    public static final String WEB_EXPECTED_NULL = "expectedNull";

    public static final String WEB_INVERT = "invert";

    private JSONPathAssertionMapper(JSONPathAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSONPathAssertionMapper(Map<String, Object> attributes){
        this(new JSONPathAssertion(), attributes);
    }

    public JSONPathAssertionMapper(JSONPathAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public JSONPathAssertion fromAttributes() {
        element.setJsonPath(getString(attributes.get(WEB_JSON_PATH)));
        element.setJsonValidationBool(getBoolean(attributes.get(WEB_JSON_VALIDATION)));
        element.setIsRegex(getBoolean(attributes.get(WEB_IS_REGEX)));
        element.setExpectedValue(getString(attributes.get(WEB_EXPECTED_VALUE)));
        element.setExpectNull(getBoolean(attributes.get(WEB_EXPECTED_NULL)));
        element.setInvert(getBoolean(attributes.get(WEB_INVERT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.JSONPathAssertion);

        attributes.put(WEB_JSON_PATH, element.getJsonPath());
        attributes.put(WEB_JSON_VALIDATION, element.isJsonValidationBool());
        attributes.put(WEB_IS_REGEX, element.isUseRegex());
        attributes.put(WEB_EXPECTED_VALUE, element.getExpectedValue());
        attributes.put(WEB_EXPECTED_NULL, element.isExpectNull());
        attributes.put(WEB_INVERT, element.isInvert());
        return attributes;
    }
}
