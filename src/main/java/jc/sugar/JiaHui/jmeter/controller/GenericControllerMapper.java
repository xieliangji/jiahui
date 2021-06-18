package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperRoot;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import org.apache.jmeter.control.GenericController;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(JMeterElementType.GenericController)
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
