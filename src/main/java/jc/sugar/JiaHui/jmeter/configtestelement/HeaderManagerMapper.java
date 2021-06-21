package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.testelement.property.PropertyIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.HeaderManager, testGuiClass = JMeterElement.HeaderManager)
public class HeaderManagerMapper extends JMeterElementMapperRoot<HeaderManager> {

    public static final String WEB_HEADER = "headers";

    public static final String WEB_HEADER_NAME = "name";

    public static final String WEB_HEADER_VALUE = "value";

    private HeaderManagerMapper(HeaderManager element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public HeaderManagerMapper(Map<String, Object> attributes){
        this(new HeaderManager(), attributes);
    }

    public HeaderManagerMapper(HeaderManager element){
        this(element, new HashMap<>());
    }

    @Override
    public HeaderManager fromAttributes() {
        List<Map<String, Object>> headerAttributesList = (List<Map<String, Object>>) attributes.get(WEB_HEADER);
        for(Map<String, Object> headerAttributes: headerAttributesList){
            Header header = new Header(getString(headerAttributes.get(WEB_HEADER_NAME)), getString(headerAttributes.get(WEB_HEADER_VALUE)));
            element.add(header);
        }

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.HeaderManager);

        PropertyIterator iterator = element.getHeaders().iterator();
        List<Map<String, Object>> headerAttributesList = new ArrayList<>();
        while (iterator.hasNext()){
            Map<String, Object> headerAttributes = new HashMap<>();
            Header header = (Header) iterator.next().getObjectValue();
            headerAttributes.put(WEB_ID, System.identityHashCode(header));
            headerAttributes.put(WEB_HEADER_NAME, header.getName());
            headerAttributes.put(WEB_HEADER_VALUE, header.getValue());
            headerAttributesList.add(headerAttributes);
        }
        attributes.put(WEB_HEADER, headerAttributesList);

        return attributes;
    }
}
