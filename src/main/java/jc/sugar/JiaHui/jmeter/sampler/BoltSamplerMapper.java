package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.bolt.sampler.BoltSampler;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.BoltSampler, testGuiClass = JMeterElement.BoltSampler)
public class BoltSamplerMapper extends AbstractJMeterElementMapper<BoltSampler> {
    public static final String WEB_CYPHER = "cypher";

    public static final String WEB_PARAMS = "params";

    public static final String WEB_RECORD_QUERY_RESULTS = "recordQueryResults";

    private BoltSamplerMapper(BoltSampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public BoltSamplerMapper(Map<String, Object> attributes){
        this(new BoltSampler(), attributes);
    }

    public BoltSamplerMapper(BoltSampler element){
        this(element, new HashMap<>());
    }

    @Override
    public BoltSampler fromAttributes() {
        element.setProperty(WEB_CYPHER, getString(attributes.get(WEB_CYPHER)));
        element.setProperty(WEB_PARAMS, getString(attributes.get(WEB_PARAMS)));
        element.setProperty(WEB_RECORD_QUERY_RESULTS, getBoolean(attributes.get(WEB_RECORD_QUERY_RESULTS)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.BoltSampler);

        attributes.put(WEB_CYPHER, element.getProperty(WEB_CYPHER));
        attributes.put(WEB_PARAMS, element.getProperty(WEB_PARAMS));
        attributes.put(WEB_RECORD_QUERY_RESULTS, element.getProperty(WEB_RECORD_QUERY_RESULTS));
        return attributes;
    }
}
