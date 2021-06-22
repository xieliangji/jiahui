package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.testelement.property.PropertyIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

/**
 * 2021/5/24 17:09
 * Code by 谢良基
 */
@JMeterElementMapperFor(value = JMeterElementType.Arguments, testGuiClass = JMeterElement.Arguments)
public class ArgumentsMapper extends AbstractJMeterElementMapper<Arguments> {

    //+ JMX field names - do not change values.
    public static final String ARGUMENTS = "Arguments.arguments"; //$NON-NLS-1$

    public static final String ARG_NAME = "Argument.name"; // $NON-NLS-1$

    /** Name used to store the argument's value. */
    public static final String VALUE = "Argument.value"; // $NON-NLS-1$

    /** Name used to store the argument's description. */
    public static final String DESCRIPTION = "Argument.desc"; // $NON-NLS-1$

    /** Name used to store the argument's metadata. */
    public static final String METADATA = "Argument.metadata";

    //+ MAP key names - do not change values.
    public static final String WEB_ARGUMENTS = "arguments";

    public static final String WEB_ARGUMENT_NAME = "name";

    public static final String WEB_ARGUMENT_VALUE = "value";

    public static final String WEB_ARGUMENT_DESCRIPTION = "desc";

    public static final String WEB_ARGUMENT_METADATA = "metadata";

    public static final String WEB_ALWAYS_ENCODE = "alwaysEncode";

    public static final String WEB_USE_EQUALS = "useEquals";

    public static final String WEB_CONTENT_TYPE = "contentType";

    public static final String WEB_FILE_PATH = "path";

    public static final String WEB_FILE_PARAMNAME = "paramName";

    public static final String WEB_FILE_MIMETYPE = "mimetype";

    private ArgumentsMapper(Arguments element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ArgumentsMapper(Map<String, Object> attributes){
        this(new Arguments(), attributes);
    }

    public ArgumentsMapper(Arguments element){
        this(element, new HashMap<>());
    }


    @Override
    public Arguments fromAttributes() {
        List<Map<String, Object>> argumentAttributes = (List<Map<String, Object>>) attributes.get(WEB_ARGUMENTS);
        for(Map<String, Object> argumentAttribute: argumentAttributes){
            element.addArgument(new Argument(
                    getString(argumentAttribute.get(WEB_ARGUMENT_NAME)),
                    getString(argumentAttribute.get(WEB_ARGUMENT_VALUE)),
                    getString(argumentAttribute.get(WEB_ARGUMENT_METADATA)),
                    getString(argumentAttribute.get(WEB_ARGUMENT_DESCRIPTION))
            ));
        }

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.Arguments);

        PropertyIterator iterator = element.iterator();
        List<Map<String, Object>> argumentAttributesList = new ArrayList<>();
        while (iterator.hasNext()){
            Map<String, Object> argumentAttributes = new HashMap<>();
            Argument argument = (Argument) iterator.next().getObjectValue();
            argumentAttributes.put(WEB_ARGUMENT_NAME, argument.getName());
            argumentAttributes.put(WEB_ARGUMENT_VALUE, argument.getValue());
            argumentAttributes.put(WEB_ARGUMENT_METADATA, argument.getMetaData());
            argumentAttributes.put(WEB_ARGUMENT_DESCRIPTION, argument.getDescription());
            argumentAttributesList.add(argumentAttributes);
        }
        attributes.put(WEB_ARGUMENTS, argumentAttributesList);
        return attributes;
    }
}
