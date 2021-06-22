package jc.sugar.JiaHui.jmeter.testplan;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.configtestelement.ArgumentsMapper;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.testelement.TestPlan;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

/**
 * 2021/5/21 17:27
 * Code by 谢良基
 */
@JMeterElementMapperFor(value = JMeterElementType.TestPlan, testGuiClass = JMeterElement.TestPlan)
public class TestPlanMapper extends AbstractJMeterElementMapper<TestPlan> {
    //+ JMX field names - do not change values
    private static final String FUNCTIONAL_MODE = "TestPlan.functional_mode"; //$NON-NLS-1$

    private static final String USER_DEFINED_VARIABLES = "TestPlan.user_defined_variables"; //$NON-NLS-1$

    private static final String SERIALIZE_THREADGROUPS = "TestPlan.serialize_threadgroups"; //$NON-NLS-1$

    private static final String CLASSPATHS = "TestPlan.user_define_classpath"; //$NON-NLS-1$

    private static final String TEARDOWN_ON_SHUTDOWN = "TestPlan.tearDown_on_shutdown"; //$NON-NLS-1$


    //+ Map key names - do not change values (web)
    private static final String WEB_FUNCTIONAL_MODE = "functionalMode";

    private static final String WEB_USER_DEFINED_VARIABLES = "arguments";

    private static final String WEB_SERIALIZE_THREADGROUPS = "serializeThreadgroups";

    private static final String WEB_CLASSPATHS = "userDefineClasspath";

    private static final String WEB_TEARDOWN_ON_SHUTDOWN = "teardownOnShutdown";

    private TestPlanMapper(TestPlan element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public TestPlanMapper(Map<String, Object> attributes){
        this(new TestPlan(), attributes);
    }

    public TestPlanMapper(TestPlan element){
        this(element, new HashMap<>());
    }


    @Override
    public TestPlan fromAttributes() {
        element.setFunctionalMode(getBoolean(attributes.get(WEB_FUNCTIONAL_MODE)));
        element.setSerialized(getBoolean(attributes.get(WEB_SERIALIZE_THREADGROUPS)));
        element.setTearDownOnShutdown(getBoolean(attributes.get(WEB_TEARDOWN_ON_SHUTDOWN)));
        element.setTestPlanClasspath(getString(attributes.get(WEB_CLASSPATHS)));

        ArgumentsMapper argumentsMapper = new ArgumentsMapper(attributes);
        Arguments arguments = argumentsMapper.fromAttributes();
        element.setUserDefinedVariables(arguments);

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.TestPlan);
        attributes.put(WEB_TYPE, JMeterElementType.TestPlan);

        attributes.put(WEB_SERIALIZE_THREADGROUPS, element.isSerialized());
        attributes.put(WEB_CLASSPATHS, element.getTestPlanClasspath());
        attributes.put(WEB_FUNCTIONAL_MODE, element.isFunctionalMode());
        attributes.put(WEB_TEARDOWN_ON_SHUTDOWN, element.isTearDownOnShutdown());

        Arguments arguments = element.getArguments();
        Map<String, Object> argumentAttributes = new ArgumentsMapper(arguments).toAttributes();
        attributes.put(WEB_USER_DEFINED_VARIABLES, argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENTS));

        return attributes;
    }
}
