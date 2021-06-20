package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperRoot;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import org.apache.jmeter.control.TransactionController;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;

@JMeterElementMapperFor(JMeterElementType.TransactionController)
public class TransactionControllerMapper extends JMeterElementMapperRoot<TransactionController> {

    public static final String WEB_PARENT = "parent";

    public static final String WEB_INCLUDE_TIMERS = "includeTimers";

    private TransactionControllerMapper(TransactionController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public TransactionControllerMapper(Map<String, Object> attributes){
        this(new TransactionController(), attributes);
    }

    public TransactionControllerMapper(TransactionController element){
        this(element, new HashMap<>());
    }


    @Override
    public TransactionController fromAttributes() {
        element.setGenerateParentSample(getBoolean(attributes.get(WEB_PARENT)));
        element.setIncludeTimers(getBoolean(attributes.get(WEB_INCLUDE_TIMERS)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.TransactionController);

        attributes.put(WEB_PARENT, element.isGenerateParentSample());
        attributes.put(WEB_INCLUDE_TIMERS, element.isIncludeTimers());
        return attributes;
    }
}
