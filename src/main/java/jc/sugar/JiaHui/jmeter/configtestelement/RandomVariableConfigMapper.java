package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.RandomVariableConfig;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.RandomVariableConfig, testGuiClass = JMeterElement.RandomVariableConfig)
public class RandomVariableConfigMapper extends JMeterElementMapperRoot<RandomVariableConfig> {

    public static final String WEB_VARIABLE_NAME = "variableName";

    public static final String WEB_OUTPUT_FORMAT = "outputFormat";

    public static final String WEB_MINIMUM_VALUE = "minimumValue";

    public static final String WEB_MAXIMUM_VALUE = "maximumValue";

    public static final String WEB_RANDOM_SEED = "randomSeed";

    public static final String WEB_PER_THREAD = "perThread";


    private RandomVariableConfigMapper(RandomVariableConfig element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public RandomVariableConfigMapper(Map<String, Object> attributes){
        this(new RandomVariableConfig(), attributes);
    }

    public RandomVariableConfigMapper(RandomVariableConfig element){
        this(element, new HashMap<>());
    }

    @Override
    public RandomVariableConfig fromAttributes() {
        element.setProperty(WEB_VARIABLE_NAME, getString(attributes.get(WEB_VARIABLE_NAME)));
        element.setProperty(WEB_OUTPUT_FORMAT, getString(attributes.get(WEB_OUTPUT_FORMAT)));
        element.setProperty(WEB_MINIMUM_VALUE, getString(attributes.get(WEB_MINIMUM_VALUE)));
        element.setProperty(WEB_MAXIMUM_VALUE, getString(attributes.get(WEB_MAXIMUM_VALUE)));
        element.setProperty(WEB_RANDOM_SEED, getString(attributes.get(WEB_RANDOM_SEED)));
        element.setProperty(WEB_PER_THREAD, getBoolean(attributes.get(WEB_PER_THREAD)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.RandomVariableConfig);

        attributes.put(WEB_VARIABLE_NAME, element.getPropertyAsString(WEB_VARIABLE_NAME));
        attributes.put(WEB_OUTPUT_FORMAT, element.getPropertyAsString(WEB_OUTPUT_FORMAT));
        attributes.put(WEB_MINIMUM_VALUE, element.getPropertyAsString(WEB_MINIMUM_VALUE));
        attributes.put(WEB_MAXIMUM_VALUE, element.getPropertyAsString(WEB_MAXIMUM_VALUE));
        attributes.put(WEB_RANDOM_SEED, element.getPropertyAsString(WEB_RANDOM_SEED));
        attributes.put(WEB_PER_THREAD, element.getPropertyAsBoolean(WEB_PER_THREAD));

        return attributes;
    }
}
