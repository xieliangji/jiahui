package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.bolt.config.BoltConnectionElement;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.BoltConnectionElement, testGuiClass = JMeterElement.BoltConnectionElement)
public class BoltConnectionElementMapper extends AbstractJMeterElementMapper<BoltConnectionElement> {

    public static final String WEB_BOLT_URI = "boltUri";

    public static final String WEB_USERNAME = "username";

    public static final String WEB_PASSWORD = "password";

    private BoltConnectionElementMapper(BoltConnectionElement element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public BoltConnectionElementMapper(Map<String, Object> attributes){
        this(new BoltConnectionElement(), attributes);
    }

    public BoltConnectionElementMapper(BoltConnectionElement element){
        this(element, new HashMap<>());
    }

    @Override
    public BoltConnectionElement fromAttributes() {
        element.setProperty(WEB_BOLT_URI, getString(attributes.get(WEB_BOLT_URI)));
        element.setProperty(WEB_USERNAME, getString(attributes.get(WEB_USERNAME)));
        element.setProperty(WEB_PASSWORD, getString(attributes.get(WEB_PASSWORD)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.BoltConnectionElement);

        attributes.put(WEB_BOLT_URI, element.getProperty(WEB_BOLT_URI));
        attributes.put(WEB_USERNAME, element.getProperty(WEB_USERNAME));
        attributes.put(WEB_PASSWORD, element.getProperty(WEB_PASSWORD));
        return attributes;
    }
}
