package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.sampler.TCPSamplerMapper;
import org.apache.jmeter.config.ConfigTestElement;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.TCPConfig, testGuiClass = JMeterElement.TCPConfig)
public class TCPConfigMapper extends AbstractJMeterElementMapper<ConfigTestElement> {
    private TCPConfigMapper(ConfigTestElement element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public TCPConfigMapper(Map<String, Object> attributes){
        this(new ConfigTestElement(), attributes);
    }

    public TCPConfigMapper(ConfigTestElement element){
        this(element, new HashMap<>());
    }

    @Override
    public ConfigTestElement fromAttributes() {
        TCPSamplerMapper.setTcpElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.TCPConfig);
        TCPSamplerMapper.setTcpAttributes(attributes, element);
        return attributes;
    }
}
