package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.control.CacheManager;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getInt;

@JMeterElementMapperFor(value = JMeterElementType.CacheManager, testGuiClass = JMeterElement.CacheManager)
public class CacheManagerMapper extends AbstractJMeterElementMapper<CacheManager> {

    public static final String WEB_CLEAR_EACH_ITERATION = "clearEachIteration";

    public static final String WEB_CONTROLLED_BY_THREAD = "controlledByThread";

    public static final String WEB_USE_EXPIRES = "useExpires";

    public static final String WEB_MAX_SIZE = "maxSize";

    private CacheManagerMapper(CacheManager element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public CacheManagerMapper(Map<String, Object> attributes){
        this(new CacheManager(), attributes);
    }

    public CacheManagerMapper(CacheManager element){
        this(element, new HashMap<>());
    }

    @Override
    public CacheManager fromAttributes() {
        element.setClearEachIteration(getBoolean(attributes.get(WEB_CLEAR_EACH_ITERATION)));
        element.setControlledByThread(getBoolean(attributes.get(WEB_CONTROLLED_BY_THREAD)));
        element.setUseExpires(getBoolean(attributes.get(WEB_USE_EXPIRES)));
        element.setMaxSize(getInt(attributes.get(WEB_MAX_SIZE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.CacheManager);

        attributes.put(WEB_CLEAR_EACH_ITERATION, element.getClearEachIteration());
        attributes.put(WEB_CONTROLLED_BY_THREAD, element.getControlledByThread());
        attributes.put(WEB_USE_EXPIRES, element.getUseExpires());
        attributes.put(WEB_MAX_SIZE, element.getMaxSize());

        return attributes;
    }
}
