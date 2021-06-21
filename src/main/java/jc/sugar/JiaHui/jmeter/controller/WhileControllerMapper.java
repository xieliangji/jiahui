package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.WhileController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.WhileController, testGuiClass = JMeterElement.WhileController)
public class WhileControllerMapper extends JMeterElementMapperRoot<WhileController> {
    public static final String WEB_CONDITION = "condition";

    private WhileControllerMapper(WhileController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public WhileControllerMapper(Map<String, Object> attributes){
        this(new WhileController(), attributes);
    }

    public WhileControllerMapper(WhileController element){
        this(element, new HashMap<>());
    }

    @Override
    public WhileController fromAttributes() {
        element.setCondition(getString(attributes.get(WEB_CONDITION)));

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.WhileController);

        attributes.put(WEB_CONDITION, element.getCondition());

        return attributes;
    }
}
