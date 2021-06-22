package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.MD5HexAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.MD5HexAssertion, testGuiClass = JMeterElement.MD5HexAssertion)
public class MD5AssertionMapper extends AbstractJMeterElementMapper<MD5HexAssertion> {
    public static final String WEB_SIZE = "size";

    private MD5AssertionMapper(MD5HexAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public MD5AssertionMapper(Map<String, Object> attributes){
        this(new MD5HexAssertion(), attributes);
    }

    public MD5AssertionMapper(MD5HexAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public MD5HexAssertion fromAttributes() {
        element.setAllowedMD5Hex(getString(attributes.get(WEB_SIZE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.MD5HexAssertion);
        attributes.put(WEB_SIZE, element.getAllowedMD5Hex());
        return attributes;
    }
}
