package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.IfController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;


@JMeterElementMapperFor(value = JMeterElementType.IfController, testGuiClass = JMeterElement.IfController)
public class IfControllerMapper extends JMeterElementMapperRoot<IfController> {

    public static final String WEB_CONDITION = "condition";

    public static final String WEB_USE_EXPRESSION = "useExpression";

    public static final String WEB_EVALUATE_ALL = "evaluateAll";


    private IfControllerMapper(IfController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public IfControllerMapper(Map<String, Object> attributes){
        this(new IfController(), attributes);
    }

    public IfControllerMapper(IfController element){
        this(element, new HashMap<>());
    }

    @Override
    public IfController fromAttributes() {
        element.setCondition(getString(attributes.get(WEB_CONDITION)));
        element.setUseExpression(getBoolean(attributes.get(WEB_USE_EXPRESSION)));
        element.setEvaluateAll(getBoolean(attributes.get(WEB_EVALUATE_ALL)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.IfController);

        attributes.put(WEB_CONDITION, element.getCondition());
        attributes.put(WEB_USE_EXPRESSION, element.isUseExpression());
        attributes.put(WEB_EVALUATE_ALL, element.isEvaluateAll());
        return attributes;
    }
}
