package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.InterleaveControl;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getInt;

@JMeterElementMapperFor(value = JMeterElementType.InterleaveControl, testGuiClass = JMeterElement.InterleaveControl)
public class InterleaveControlMapper extends AbstractJMeterElementMapper<InterleaveControl> {
    public static final String WEB_STYLE = "style";

    public static final String WEB_ACCROSS_THREADS = "accrossThreads";


    private InterleaveControlMapper(InterleaveControl element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public InterleaveControlMapper(Map<String, Object> attributes){
        this(new InterleaveControl(), attributes);
    }

    public InterleaveControlMapper(InterleaveControl element){
        this(element, new HashMap<>());
    }

    @Override
    public InterleaveControl fromAttributes() {
        element.setStyle(getInt(attributes.get(WEB_STYLE)));
        element.setInterleaveAccrossThreads(getBoolean(attributes.get(WEB_ACCROSS_THREADS)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.InterleaveControl);
        attributes.put(WEB_STYLE, element.getStyle());
        attributes.put(WEB_ACCROSS_THREADS, element.getInterleaveAccrossThreads());
        return attributes;
    }
}
