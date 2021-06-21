package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.RandomOrderController;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.RandomOrderController, testGuiClass = JMeterElement.RandomOrderController)
public class RandomOrderControllerMapper extends JMeterElementMapperRoot<RandomOrderController> {
    private RandomOrderControllerMapper(RandomOrderController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public RandomOrderControllerMapper(Map<String, Object> attributes){
        this(new RandomOrderController(), attributes);
    }

    public RandomOrderControllerMapper(RandomOrderController element){
        this(element, new HashMap<>());
    }

    @Override
    public RandomOrderController fromAttributes() {
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.RandomOrderController);
        return attributes;
    }
}
