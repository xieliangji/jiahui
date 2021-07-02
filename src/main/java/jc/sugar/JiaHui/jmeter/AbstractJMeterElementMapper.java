package jc.sugar.JiaHui.jmeter;

import org.apache.jmeter.testelement.AbstractScopedTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

public abstract class AbstractJMeterElementMapper<T extends TestElement> implements JMeterElementMapper<T> {
    private final Logger logger = LogManager.getLogger(AbstractJMeterElementMapper.class);

    // +JMX scope property name.
    public static final String SCOPE = "Sample.scope";

    public static final String SCOPE_VARIABLE_NAME = "Scope.variable";

    public static final String WEB_ID = "id";

    public static final String WEB_CATEGORY = "category";

    public static final String WEB_TYPE = "type";

    public static final String WEB_GUICLASS = "guiclass";

    public static final String WEB_TESTCLASS = "testclass";

    public static final String WEB_TESTNAME = "testname";

    public static final String WEB_ENABLED = "enabled";

    public static final String WEB_COMMENTS = "comments";


    public static final String WEB_SCOPE = "scope";

    public static final String WEB_SCOPE_VARIABLE_NAME = "variable";


    protected T element;

    protected Map<String, Object> attributes;

    public AbstractJMeterElementMapper(T element, Map<String, Object> attributes){
        this.element = element;
        this.attributes = attributes;
        init();
    }

    private void init(){
        // 属性map为空，表明是从element to map
        if(attributes.size() == 0){
            logger.info("element to map - [" + element.getClass() + "]");
            attributes.put(WEB_ID, System.identityHashCode(element));
            String guiClass = element.getPropertyAsString(TestElement.GUI_CLASS);
            String testClass = element.getPropertyAsString(TestElement.TEST_CLASS);
            attributes.put(WEB_GUICLASS, guiClass.substring(guiClass.lastIndexOf('.') + 1));
            attributes.put(WEB_TESTCLASS, testClass.substring(testClass.lastIndexOf('.') + 1));
            attributes.put(WEB_TESTNAME, element.getName());
            attributes.put(WEB_COMMENTS, element.getComment());
            attributes.put(WEB_ENABLED, element.isEnabled());
            if(element instanceof AbstractScopedTestElement){
                attributes.put(WEB_SCOPE, element.getPropertyAsString(SCOPE));
                attributes.put(WEB_SCOPE_VARIABLE_NAME, element.getPropertyAsString(SCOPE_VARIABLE_NAME));
            }
        } else{
            // map 不为空，则是从map to element
            logger.info("map to element - [" + element.getClass() + "]");
            element.setProperty(TestElement.GUI_CLASS, getString(attributes.get(WEB_GUICLASS)));
            element.setProperty(TestElement.TEST_CLASS, getString(attributes.get(WEB_TESTCLASS)));
            element.setProperty(TestElement.NAME, getString(attributes.get(WEB_TESTNAME)));
            element.setProperty(TestElement.COMMENTS, getString(attributes.get(WEB_COMMENTS)));
            element.setProperty(TestElement.ENABLED, getBoolean(attributes.get(WEB_ENABLED)));
            if(element instanceof AbstractScopedTestElement){
                element.setProperty(SCOPE, getString(attributes.get(WEB_SCOPE)));
                if(getString(attributes.get(WEB_SCOPE)).equals("variable")){
                    element.setProperty(SCOPE_VARIABLE_NAME, getString(attributes.get(WEB_SCOPE_VARIABLE_NAME)));
                }
            }
        }
    }
}
