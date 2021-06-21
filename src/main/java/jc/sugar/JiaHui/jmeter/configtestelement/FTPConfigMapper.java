package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.sampler.FTPSamplerMapper;
import org.apache.jmeter.config.ConfigTestElement;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.FtpConfig, testGuiClass = JMeterElement.FTPConfig)
public class FTPConfigMapper extends JMeterElementMapperRoot<ConfigTestElement> {
    private FTPConfigMapper(ConfigTestElement element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public FTPConfigMapper(Map<String, Object> attributes){
        this(new ConfigTestElement(), attributes);
    }

    public FTPConfigMapper(ConfigTestElement element){
        this(element, new HashMap<>());
    }

    @Override
    public ConfigTestElement fromAttributes() {
        FTPSamplerMapper.setFTPElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.FtpConfig);
        FTPSamplerMapper.setFTPAttributes(attributes, element);
        return attributes;
    }
}
