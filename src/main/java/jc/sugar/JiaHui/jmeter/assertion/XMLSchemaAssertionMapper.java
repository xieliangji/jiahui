package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.XMLSchemaAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.XMLSchemaAssertion, testGuiClass = JMeterElement.XMLSchemaAssertion)
public class XMLSchemaAssertionMapper extends AbstractJMeterElementMapper<XMLSchemaAssertion> {

    public static final String WEB_XML_SCHEMA_ASSERTION_FILENAME = "xmlSchemaAssertionFilename";

    private XMLSchemaAssertionMapper(XMLSchemaAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public XMLSchemaAssertionMapper(Map<String, Object> attributes){
        this(new XMLSchemaAssertion(), attributes);
    }

    public XMLSchemaAssertionMapper(XMLSchemaAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public XMLSchemaAssertion fromAttributes() {
        element.setXsdFileName(getString(attributes.get(WEB_XML_SCHEMA_ASSERTION_FILENAME)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.XMLSchemaAssertion);
        attributes.put(WEB_XML_SCHEMA_ASSERTION_FILENAME, element.getXsdFileName());
        return attributes;
    }
}
