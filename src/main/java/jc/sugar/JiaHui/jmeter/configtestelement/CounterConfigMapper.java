package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.modifiers.CounterConfig;

import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

@JMeterElementMapperFor(value = JMeterElementType.CounterConfig, testGuiClass = JMeterElement.CounterConfig)
public class CounterConfigMapper extends AbstractJMeterElementMapper<CounterConfig> {

    public static final String WEB_INCR = "incr";

    public static final String WEB_END = "end";

    public static final String WEB_FORMAT = "format";

    public static final String WEB_NAME = "name";

    public static final String WEB_PER_USER = "perUser";

    public static final String WEB_RESET_ON_TG_ITERATION = "resetOnTgIteration";

    public static final String WEB_START = "start";

    private CounterConfigMapper(CounterConfig element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    @Override
    public CounterConfig fromAttributes() {
        element.setIncrement(getLong(attributes.get(attributes.get(WEB_INCR))));
        element.setEnd(getLong(attributes.get(WEB_END)));
        element.setFormat(getString(attributes.get(WEB_FORMAT)));
        element.setName(getString(attributes.get(WEB_NAME)));
        element.setIsPerUser(getBoolean(attributes.get(WEB_PER_USER)));
        element.setResetOnThreadGroupIteration(getBoolean(attributes.get(WEB_RESET_ON_TG_ITERATION)));
        element.setStart(getLong(attributes.get(WEB_START)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.CounterConfig);

        attributes.put(WEB_INCR, element.getIncrementAsString());
        attributes.put(WEB_END, element.getEndAsString());
        attributes.put(WEB_FORMAT, element.getFormat());
        attributes.put(WEB_NAME, element.getName());
        attributes.put(WEB_PER_USER, element.isPerUser());
        attributes.put(WEB_RESET_ON_TG_ITERATION, element.isResetOnThreadGroupIteration());
        attributes.put(WEB_START, element.getStartAsString());

        return attributes;
    }
}
