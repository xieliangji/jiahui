package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperRoot;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import org.apache.jmeter.control.OnceOnlyController;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(JMeterElementType.OnceOnlyController)
public class OnceOnlyControllerMapper extends JMeterElementMapperRoot<OnceOnlyController> {
    private OnceOnlyControllerMapper(OnceOnlyController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public OnceOnlyControllerMapper(Map<String, Object> attributes){
        this(new OnceOnlyController(), attributes);
    }

    public OnceOnlyControllerMapper(OnceOnlyController element){
        this(element, new HashMap<>());
    }

    @Override
    public OnceOnlyController fromAttributes() {
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.OnceOnlyController);
        return attributes;
    }
}
