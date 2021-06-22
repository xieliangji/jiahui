package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.sampler.JDBCSamplerMapper;
import org.apache.jmeter.protocol.jdbc.processor.JDBCPreProcessor;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.JDBCPreProcessor, testGuiClass = JMeterElement.JDBCPreProcessor)
public class JDBCPreProcessorMapper extends AbstractJMeterElementMapper<JDBCPreProcessor> {
    private JDBCPreProcessorMapper(JDBCPreProcessor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JDBCPreProcessorMapper(Map<String, Object> attributes){
        this(new JDBCPreProcessor(), attributes);
    }

    public JDBCPreProcessorMapper(JDBCPreProcessor element){
        this(element, new HashMap<>());
    }

    @Override
    public JDBCPreProcessor fromAttributes() {
        JDBCSamplerMapper.setElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        JDBCSamplerMapper.setAttributes(attributes, element);
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.JDBCPreProcessor);
        return attributes;
    }
}
