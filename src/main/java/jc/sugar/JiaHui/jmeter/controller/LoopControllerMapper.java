package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.testelement.TestElement;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

/**
 * 2021/5/25 17:47
 * Code by 谢良基
 */
@JMeterElementMapperFor(value = JMeterElementType.LoopController, testGuiClass = JMeterElement.LoopController)
public class LoopControllerMapper extends JMeterElementMapperRoot<LoopController> {

    //+ JMX field names - do not change values.
    public static final String CONTINUE_FOREVER = "LoopController.continue_forever"; // $NON-NLS-1$


    //+ MAP key names - do not change values.
    public static final String WEB_LOOPS = "loops";

    public static final String WEB_CONTINUE_FOREVER = "continueForever";

    private LoopControllerMapper(LoopController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public LoopControllerMapper(Map<String, Object> attributes){
        this(new LoopController(), attributes);
    }

    public LoopControllerMapper(LoopController element){
        this(element, new HashMap<>());
    }


    @Override
    public LoopController fromAttributes() {
        element.setLoops(getString(attributes.get(WEB_LOOPS)));
        element.setContinueForever(getBoolean(attributes.get(WEB_CONTINUE_FOREVER)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.LoopController);

        attributes.put(WEB_LOOPS, element.getLoopString());
        attributes.put(WEB_CONTINUE_FOREVER, element.getPropertyAsBoolean(CONTINUE_FOREVER));
        return attributes;
    }
}
