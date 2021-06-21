package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.RandomController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getInt;

@JMeterElementMapperFor(value = JMeterElementType.RandomController, testGuiClass = JMeterElement.RandomController)
public class RandomControllerMapper extends JMeterElementMapperRoot<RandomController> {
    public static final String WEB_STYLE = "style";

    private RandomControllerMapper(RandomController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public RandomControllerMapper(Map<String, Object> attributes){
        this(new RandomController(), attributes);
    }

    public RandomControllerMapper(RandomController element){
        this(element, new HashMap<>());
    }

    @Override
    public RandomController fromAttributes() {
        element.setStyle(getInt(attributes.get(WEB_STYLE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.RandomController);

        attributes.put(WEB_STYLE, element.getStyle());

        return attributes;
    }
}
