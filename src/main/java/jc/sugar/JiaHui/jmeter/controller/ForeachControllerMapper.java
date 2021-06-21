package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.ForeachController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.ForeachController, testGuiClass = JMeterElement.ForeachController)
public class ForeachControllerMapper extends JMeterElementMapperRoot<ForeachController> {
    public static final String WEB_INPUT_VAL = "inputVal";

    public static final String WEB_START_INDEX = "startIndex";

    public static final String WEB_END_INDEX = "endIndex";

    public static final String WEB_RETURN_VAL = "returnVal";

    public static final String WEB_USE_SEPARATOR = "useSeparator";

    private ForeachControllerMapper(ForeachController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ForeachControllerMapper(Map<String, Object> attributes){
        this(new ForeachController(), attributes);
    }

    public ForeachControllerMapper(ForeachController element){
        this(element, new HashMap<>());
    }

    @Override
    public ForeachController fromAttributes() {
        element.setInputVal(getString(attributes.get(WEB_INPUT_VAL)));
        element.setStartIndex(getString(attributes.get(WEB_START_INDEX)));
        element.setEndIndex(getString(attributes.get(WEB_END_INDEX)));
        element.setReturnVal(getString(attributes.get(WEB_RETURN_VAL)));
        element.setUseSeparator(getBoolean(attributes.get(WEB_USE_SEPARATOR)));

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.ForeachController);

        attributes.put(WEB_INPUT_VAL, element.getInputValString());
        attributes.put(WEB_START_INDEX, element.getStartIndexAsString());
        attributes.put(WEB_END_INDEX, element.getEndIndexAsString());
        attributes.put(WEB_RETURN_VAL, element.getReturnValString());
        attributes.put(WEB_USE_SEPARATOR, element.getUseSeparator());
        return attributes;
    }
}
