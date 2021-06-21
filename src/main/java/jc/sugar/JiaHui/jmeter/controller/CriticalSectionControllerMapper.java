package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.CriticalSectionController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.CriticalSectionController, testGuiClass = JMeterElement.CriticalSectionController)
public class CriticalSectionControllerMapper extends JMeterElementMapperRoot<CriticalSectionController> {
    public static final String WEB_LOCK_NAME = "lockName";

    private CriticalSectionControllerMapper(CriticalSectionController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public CriticalSectionControllerMapper(Map<String, Object> attributes){
        this(new CriticalSectionController(), attributes);
    }

    public CriticalSectionControllerMapper(CriticalSectionController element){
        this(element, new HashMap<>());
    }

    @Override
    public CriticalSectionController fromAttributes() {
        element.setLockName(getString(attributes.get(WEB_LOCK_NAME)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.CriticalSectionController);
        attributes.put(WEB_LOCK_NAME, element.getLockName());

        return attributes;
    }
}
