package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.sampler.AjpSampler;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.AjpSampler, testGuiClass = JMeterElement.AjpSampler)
public class AjpSamplerMapper extends JMeterElementMapperRoot<AjpSampler> {
    private AjpSamplerMapper(AjpSampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public AjpSamplerMapper(Map<String, Object> attributes){
        this(new AjpSampler(), attributes);
    }

    public AjpSamplerMapper(AjpSampler element){
        this(element, new HashMap<>());
    }

    @Override
    public AjpSampler fromAttributes() {
        HttpSamplerMapper.setElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        HttpSamplerMapper.setAttributes(element, attributes);
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.AjpSampler);
        return attributes;
    }
}
