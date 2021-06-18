package jc.sugar.JiaHui.jmeter;

import org.apache.jmeter.testelement.TestElement;

import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

public abstract class JMeterElementMapperRoot<T extends TestElement> implements JMeterElementMapper<T> {

    public static final String WEB_ID = "id";

    public static final String WEB_CATEGORY = "category";

    public static final String WEB_TYPE = "type";

    public static final String WEB_GUICLASS = "guiclass";

    public static final String WEB_TESTCLASS = "testclass";

    public static final String WEB_TESTNAME = "testname";

    public static final String WEB_ENABLED = "enabled";

    public static final String WEB_COMMENTS = "comments";


    protected T element;

    protected Map<String, Object> attributes;

    public JMeterElementMapperRoot(T element, Map<String, Object> attributes){
        this.element = element;
        this.attributes = attributes;
        init();
    }

    private void init(){
        // 属性map为空，表明是从element to map
        if(attributes.size() == 0){
            attributes.put(WEB_ID, System.identityHashCode(element));
            attributes.put(WEB_GUICLASS, element.getPropertyAsString(TestElement.GUI_CLASS));
            attributes.put(WEB_TESTCLASS, element.getPropertyAsString(TestElement.TEST_CLASS));
            attributes.put(WEB_TESTNAME, element.getName());
            attributes.put(WEB_COMMENTS, element.getComment());
            attributes.put(WEB_ENABLED, element.isEnabled());
        } else{
            // map 不为空，则是从map to element
            element.setProperty(TestElement.GUI_CLASS, getString(attributes.get(WEB_GUICLASS)));
            element.setProperty(TestElement.TEST_CLASS, getString(attributes.get(WEB_TESTNAME)));
            element.setProperty(TestElement.NAME, getString(attributes.get(WEB_TESTNAME)));
            element.setProperty(TestElement.COMMENTS, getString(attributes.get(WEB_COMMENTS)));
            element.setProperty(TestElement.ENABLED, getBoolean(attributes.get(WEB_ENABLED)));
        }
    }

}
