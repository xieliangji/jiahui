package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.sampler.HttpSamplerMapper;
import org.apache.jmeter.config.ConfigTestElement;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.HttpDefaults, testGuiClass = JMeterElement.HttpDefaults)
public class HttpDefaultsMapper extends AbstractJMeterElementMapper<ConfigTestElement> {
    private HttpDefaultsMapper(ConfigTestElement element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public HttpDefaultsMapper(Map<String, Object> attributes){
        this(new ConfigTestElement(), attributes);
    }

    public HttpDefaultsMapper(ConfigTestElement element){
        this(element, new HashMap<>());
    }

    @Override
    public ConfigTestElement fromAttributes() {
        HttpSamplerMapper.setElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        HttpSamplerMapper.setAttributes(element, attributes);
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.HttpDefaults);
        return attributes;
    }
}
