package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.XMLAssertion;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.XMLAssertion, testGuiClass = JMeterElement.XMLAssertion)
public class XMLAssertionMapper extends JMeterElementMapperRoot<XMLAssertion> {

    private XMLAssertionMapper(XMLAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public XMLAssertionMapper(Map<String, Object> attributes){
        this(new XMLAssertion(), attributes);
    }

    public XMLAssertionMapper(XMLAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public XMLAssertion fromAttributes() {
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.XMLAssertion);
        return attributes;
    }
}
