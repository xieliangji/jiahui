package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.XPath2Assertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.XPath2Assertion, testGuiClass = JMeterElement.XPath2Assertion)
public class XPath2AssertionMapper extends JMeterElementMapperRoot<XPath2Assertion> {

    public static final String WEB_NEGATE = "negate";

    public static final String WEB_NAMESPACES = "namespaces";

    public static final String WEB_XPATH = "xpath";

    private XPath2AssertionMapper(XPath2Assertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public XPath2AssertionMapper(Map<String, Object> attributes){
        this(new XPath2Assertion(), attributes);
    }

    public XPath2AssertionMapper(XPath2Assertion element){
        this(element, new HashMap<>());
    }

    @Override
    public XPath2Assertion fromAttributes() {
        element.setNegated(getBoolean(attributes.get(WEB_NEGATE)));
        element.setNamespaces(getString(attributes.get(WEB_NAMESPACES)));
        element.setXPathString(getString(attributes.get(WEB_XPATH)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.XPath2Assertion);

        attributes.put(WEB_NEGATE, element.isNegated());
        attributes.put(WEB_NAMESPACES, element.getNamespaces());
        attributes.put(WEB_XPATH, element.getXPathString());
        return attributes;
    }
}
