package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.sampler.JDBCSamplerMapper;
import org.apache.jmeter.protocol.jdbc.processor.JDBCPostProcessor;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.JDBCPostProcessor, testGuiClass = JMeterElement.JDBCPostProcessor)
public class JDBCPostProcessorMapper extends AbstractJMeterElementMapper<JDBCPostProcessor> {
    private JDBCPostProcessorMapper(JDBCPostProcessor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JDBCPostProcessorMapper(Map<String, Object> attributes){
        this(new JDBCPostProcessor(), attributes);
    }

    public JDBCPostProcessorMapper(JDBCPostProcessor element){
        this(element, new HashMap<>());
    }

    @Override
    public JDBCPostProcessor fromAttributes() {
        JDBCSamplerMapper.setElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.JDBCPostProcessor);

        JDBCSamplerMapper.setAttributes(attributes, element);
        return attributes;
    }
}
