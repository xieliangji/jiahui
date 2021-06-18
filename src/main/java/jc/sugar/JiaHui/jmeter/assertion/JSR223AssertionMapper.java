package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import jc.sugar.JiaHui.jmeter.common.JSR223ElementMapper;
import org.apache.jmeter.assertions.JSR223Assertion;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/5/25 10:22
 * Code by 谢良基
 */
@JMeterElementMapperFor(JMeterElementType.JSR223Assertion)
public class JSR223AssertionMapper extends JSR223ElementMapper<JSR223Assertion> {

    private JSR223AssertionMapper(JSR223Assertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSR223AssertionMapper(Map<String, Object> attributes){
        this(new JSR223Assertion(), attributes);
    }

    public JSR223AssertionMapper(JSR223Assertion element){
        this(element, new HashMap<>());
    }


    @Override
    public JSR223Assertion fromAttributes() {
        setJsr223Element(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.JSR223Assertion);
        setJsr223Attributes(attributes, element);
        return attributes;
    }
}
