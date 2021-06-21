package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.JMeterElement;
import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import jc.sugar.JiaHui.jmeter.common.JSR223ElementMapper;
import org.apache.jmeter.extractor.JSR223PostProcessor;
import org.apache.jmeter.util.JSR223TestElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/5/25 10:46
 * Code by 谢良基
 */
@JMeterElementMapperFor(value = JMeterElementType.JSR223PostProcessor, testGuiClass = JMeterElement.JSR223PostProcessor)
public class JSR223PostprocessorMapper extends JSR223ElementMapper<JSR223PostProcessor> {


    private JSR223PostprocessorMapper(JSR223PostProcessor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSR223PostprocessorMapper(Map<String, Object> attributes){
        this(new JSR223PostProcessor(), attributes);
    }

    public JSR223PostprocessorMapper(JSR223PostProcessor element){
        this(element, new HashMap<>());
    }

    @Override
    public JSR223PostProcessor fromAttributes() {
        setJsr223Element(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.JSR223PostProcessor);
        setJsr223Attributes(attributes, element);
        return attributes;
    }
}
