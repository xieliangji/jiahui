package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.jdbc.AbstractJDBCTestElement;
import org.apache.jmeter.protocol.jdbc.sampler.JDBCSampler;

import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.JDBCSampler, testGuiClass = JMeterElement.JDBCSampler)
public class JDBCSamplerMapper extends JMeterElementMapperRoot<JDBCSampler> {
    public static final String WEB_DATASOURCE = "dataSource";

    public static final String WEB_QUERY_TYPE = "queryType";

    public static final String WEB_QUERY = "query";

    public static final String WEB_QUERY_ARGUMENTS = "queryArguments";

    public static final String WEB_QUERY_ARGUMENTS_TYPES = "queryArgumentsTypes";

    public static final String WEB_VARIABLE_NAMES = "variableNames";

    public static final String WEB_RESULT_VARIABLE = "resultVariable";

    public static final String WEB_QUERY_TIMEOUT = "queryTimeout";

    public static final String WEB_RESULT_SET_MAX_ROWS = "resultSetMaxRows";

    public static final String WEB_RESULT_SET_HANDLER = "resultSetHandler";

    private JDBCSamplerMapper(JDBCSampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    @Override
    public JDBCSampler fromAttributes() {
        setElement(element, attributes);
        return element;
    }


    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.JDBCSampler);
        setAttributes(attributes, element);
        return attributes;
    }

    public static <T extends AbstractJDBCTestElement> void setElement(T element, Map<String, Object> attributes){
        element.setProperty(WEB_DATASOURCE, getString(attributes.get(WEB_DATASOURCE)));
        element.setProperty(WEB_QUERY_TYPE, getString(attributes.get(WEB_QUERY_TYPE)));
        element.setProperty(WEB_QUERY, getString(attributes.get(WEB_QUERY)));
        element.setProperty(WEB_QUERY_ARGUMENTS, getString(attributes.get(WEB_QUERY_ARGUMENTS)));
        element.setProperty(WEB_QUERY_ARGUMENTS_TYPES, getString(attributes.get(WEB_QUERY_ARGUMENTS_TYPES)));
        element.setProperty(WEB_VARIABLE_NAMES, getString(attributes.get(WEB_VARIABLE_NAMES)));
        element.setProperty(WEB_RESULT_VARIABLE, getString(attributes.get(WEB_RESULT_VARIABLE)));
        element.setProperty(WEB_QUERY_TIMEOUT, getString(attributes.get(WEB_QUERY_TIMEOUT)));
        element.setProperty(WEB_RESULT_SET_MAX_ROWS, getString(attributes.get(WEB_RESULT_SET_MAX_ROWS)));
        element.setProperty(WEB_RESULT_SET_HANDLER, getString(attributes.get(WEB_RESULT_SET_HANDLER)));
    }

    public static <T extends AbstractJDBCTestElement> void setAttributes(Map<String, Object> attributes, T element){
        attributes.put(WEB_DATASOURCE, element.getProperty(WEB_DATASOURCE));
        attributes.put(WEB_QUERY_TYPE, element.getProperty(WEB_QUERY_TYPE));
        attributes.put(WEB_QUERY, element.getProperty(WEB_QUERY));
        attributes.put(WEB_QUERY_ARGUMENTS, element.getProperty(WEB_QUERY_ARGUMENTS));
        attributes.put(WEB_QUERY_ARGUMENTS_TYPES, element.getProperty(WEB_QUERY_ARGUMENTS_TYPES));
        attributes.put(WEB_VARIABLE_NAMES, element.getProperty(WEB_VARIABLE_NAMES));
        attributes.put(WEB_RESULT_VARIABLE, element.getProperty(WEB_RESULT_VARIABLE));
        attributes.put(WEB_QUERY_TIMEOUT, element.getProperty(WEB_QUERY_TIMEOUT));
        attributes.put(WEB_RESULT_SET_MAX_ROWS, element.getProperty(WEB_RESULT_SET_MAX_ROWS));
        attributes.put(WEB_RESULT_SET_HANDLER, element.getProperty(WEB_RESULT_SET_HANDLER));
    }
}
