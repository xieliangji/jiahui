package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.SwitchController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.SwitchController, testGuiClass = JMeterElement.SwitchController)
public class SwitchControllerMapper extends AbstractJMeterElementMapper<SwitchController> {
    public static final String WEB_VALUE = "value";

    private SwitchControllerMapper(SwitchController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public SwitchControllerMapper(Map<String, Object> attributes){
        this(new SwitchController(), attributes);
    }

    public SwitchControllerMapper(SwitchController element){
        this(element, new HashMap<>());
    }

    @Override
    public SwitchController fromAttributes() {
        element.setSelection(getString(attributes.get(WEB_VALUE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.SwitchController);

        attributes.put(WEB_VALUE, element.getSelection());
        return attributes;
    }
}
