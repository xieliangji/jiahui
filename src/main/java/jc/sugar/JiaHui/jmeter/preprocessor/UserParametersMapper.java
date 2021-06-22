package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.modifiers.UserParameters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;

@JMeterElementMapperFor(value = JMeterElementType.UserParameters, testGuiClass = JMeterElement.UserParameters)
public class UserParametersMapper extends AbstractJMeterElementMapper<UserParameters> {

    public static final String WEB_PER_ITERATION = "perIteration";

    public static final String WEB_NAMES = "names";

    public static final String WEB_THREAD_VALUES = "threadValues";

    private UserParametersMapper(UserParameters element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public UserParametersMapper(Map<String, Object> attributes){
        this(new UserParameters(), attributes);
    }

    public UserParametersMapper(UserParameters element){
        this(element, new HashMap<>());
    }

    @Override
    public UserParameters fromAttributes() {
        element.setPerIteration(getBoolean(attributes.get(WEB_PER_ITERATION)));
        element.setNames((List) attributes.get(WEB_NAMES));
        element.setThreadLists((List) attributes.get(WEB_THREAD_VALUES));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.UserParameters);

        attributes.put(WEB_NAMES, element.getNames().getObjectValue());
        attributes.put(WEB_THREAD_VALUES, element.getThreadLists().getObjectValue());
        return attributes;
    }
}
