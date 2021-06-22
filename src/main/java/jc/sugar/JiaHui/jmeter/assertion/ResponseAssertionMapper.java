package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.ResponseAssertion;
import org.apache.jmeter.testelement.property.JMeterProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

@JMeterElementMapperFor(value = JMeterElementType.ResponseAssertion, testGuiClass = JMeterElement.ResponseAssertion)
public class ResponseAssertionMapper extends AbstractJMeterElementMapper<ResponseAssertion> {

    // +JMX keys
    public static final String TEST_FIELD = "Assertion.test_field";

    public static final String TEST_TYPE = "Assertion.test_type";

    public static final String WEB_TEST_FIELD = "testField";

    public static final String WEB_TEST_TYPE = "testType";

    public static final String WEB_TEST_STRING = "testString";

    public static final String WEB_ASSUME_SUCCESS = "assumeSuccess";

    public static final String WEB_CUSTOM_MESSAGE = "customMessage";

    public static final String WEB_TEST_STRING_STRING = "string";

    private ResponseAssertionMapper(ResponseAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ResponseAssertionMapper(Map<String, Object> attributes){
        this(new ResponseAssertion(), attributes);
    }

    public ResponseAssertionMapper(ResponseAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public ResponseAssertion fromAttributes() {
        element.setProperty(TEST_FIELD, getString(attributes.get(WEB_TEST_FIELD)));
        element.setProperty(TEST_TYPE, getInt(attributes.get(WEB_TEST_TYPE)));

        List<Map<String, Object>> testStrings = (List<Map<String, Object>>) attributes.get(WEB_TEST_STRING);
        for(Map<String, Object> testString: testStrings){
            element.addTestString(getString(testString.get(WEB_TEST_STRING_STRING)));
        }
        element.setAssumeSuccess(getBoolean(attributes.get(WEB_ASSUME_SUCCESS)));
        element.setCustomFailureMessage(getString(attributes.get(WEB_CUSTOM_MESSAGE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.ResponseAssertion);

        attributes.put(WEB_TEST_FIELD, element.getTestField());
        attributes.put(WEB_TEST_TYPE, element.getTestType());
        attributes.put(WEB_ASSUME_SUCCESS, element.getAssumeSuccess());
        attributes.put(WEB_CUSTOM_MESSAGE, element.getCustomFailureMessage());

        List<Map<String, Object>> testString = new ArrayList<>();
        for(JMeterProperty testStringProperty: element.getTestStrings()){
            String testStr = testStringProperty.getStringValue();
            Map<String, Object> testStringAttributes = new HashMap<>();
            testStringAttributes.put(WEB_ID, System.identityHashCode(testStr));
            testStringAttributes.put(WEB_TEST_STRING_STRING, testStr);
            testString.add(testStringAttributes);
        }
        attributes.put(WEB_TEST_STRING, testString);

        return attributes;
    }
}
