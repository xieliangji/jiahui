package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperFor;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import jc.sugar.JiaHui.jmeter.common.JSR223ElementMapper;
import org.apache.jmeter.protocol.java.sampler.JSR223Sampler;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/5/25 10:50
 * Code by 谢良基
 */
@JMeterElementMapperFor(JMeterElementType.JSR223Sampler)
public class JSR223SamplerMapper extends JSR223ElementMapper<JSR223Sampler>{


    private JSR223SamplerMapper(JSR223Sampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSR223SamplerMapper(Map<String, Object> attributes){
        this(new JSR223Sampler(), attributes);
    }

    public JSR223SamplerMapper(JSR223Sampler element){
        this(element, new HashMap<>());
    }

    @Override
    public JSR223Sampler fromAttributes() {
        setJsr223Element(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.JSR223Sampler);
        setJsr223Attributes(attributes, element);
        return attributes;
    }
}
