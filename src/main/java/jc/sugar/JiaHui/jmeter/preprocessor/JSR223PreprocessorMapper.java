package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import jc.sugar.JiaHui.jmeter.common.JSR223ElementMapper;
import jc.sugar.JiaHui.jmeter.postprocessor.JSR223PostprocessorMapper;
import org.apache.jmeter.modifiers.JSR223PreProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/5/25 10:31
 * Code by 谢良基
 */
@JMeterElementMapperFor(JMeterElementType.JSR223PreProcessor)
public class JSR223PreprocessorMapper extends JSR223ElementMapper<JSR223PreProcessor>{


    private JSR223PreprocessorMapper(JSR223PreProcessor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSR223PreprocessorMapper(Map<String, Object> attributes){
        this(new JSR223PreProcessor(), attributes);
    }

    public JSR223PreprocessorMapper(JSR223PreProcessor element){
        this(element, new HashMap<>());
    }

    @Override
    public JSR223PreProcessor fromAttributes() {
        setJsr223Element(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.JSR223PreProcessor);
        setJsr223Attributes(attributes, element);
        return attributes;
    }
}
