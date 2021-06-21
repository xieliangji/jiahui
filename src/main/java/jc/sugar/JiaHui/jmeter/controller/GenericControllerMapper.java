package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.GenericController;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.GenericController, testGuiClass = JMeterElement.GenericController)
public class GenericControllerMapper extends JMeterElementMapperRoot<GenericController> {
    private GenericControllerMapper(GenericController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public GenericControllerMapper(Map<String, Object> attributes){
        this(new GenericController(), attributes);
    }

    public GenericControllerMapper(GenericController element){
        this(element, new HashMap<>());
    }

    @Override
    public GenericController fromAttributes() {
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.GenericController);
        return attributes;
    }
}
