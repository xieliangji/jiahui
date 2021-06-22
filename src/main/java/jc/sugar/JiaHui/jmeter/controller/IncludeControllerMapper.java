package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.IncludeController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.IncludeController, testGuiClass = JMeterElement.IncludeController)
public class IncludeControllerMapper extends AbstractJMeterElementMapper<IncludeController> {
    public static final String WEB_INCLUDE_PATH = "includePath";

    private IncludeControllerMapper(IncludeController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public IncludeControllerMapper(Map<String, Object> attributes){
        this(new IncludeController(), attributes);
    }

    public IncludeControllerMapper(IncludeController element){
        this(element, new HashMap<>());
    }

    @Override
    public IncludeController fromAttributes() {
        element.setIncludePath(getString(attributes.get(WEB_INCLUDE_PATH)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.IncludeController);
        attributes.put(WEB_INCLUDE_PATH, element.getIncludePath());
        return attributes;
    }
}
