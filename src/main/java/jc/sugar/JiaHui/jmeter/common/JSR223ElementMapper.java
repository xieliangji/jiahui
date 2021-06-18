package jc.sugar.JiaHui.jmeter.common;

import jc.sugar.JiaHui.jmeter.JMeterElementMapperRoot;
import org.apache.jmeter.util.JSR223TestElement;

import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

/**
 * 2021/5/25 10:14
 * Code by 谢良基
 */
public abstract class JSR223ElementMapper<T extends JSR223TestElement> extends JMeterElementMapperRoot<T> {

    //+ JMX(MAP) field names - do not change values.
    private static final String SCRIPT_LANGUAGE = "scriptLanguage";

    private static final String PARAMETERS = "parameters";

    private static final String FILENAME = "filename";

    private static final String CACHE_KEY = "cacheKey";

    private static final String SCRIPT = "script";

    public JSR223ElementMapper(T element, Map<String, Object> attributes) {
        super(element, attributes);
    }


    public static <T extends JSR223TestElement> void setJsr223Element(T element, Map<String, Object> attributes){
        element.setProperty(SCRIPT_LANGUAGE, getString(attributes.get(SCRIPT_LANGUAGE)));
        element.setProperty(PARAMETERS, getString(attributes.get(PARAMETERS)));
        element.setProperty(FILENAME, getString(attributes.get(FILENAME)));
        element.setProperty(CACHE_KEY, getString(attributes.get(CACHE_KEY)));
        element.setProperty(SCRIPT, getString(attributes.get(SCRIPT)));
    }


    public static <T extends JSR223TestElement> void setJsr223Attributes(Map<String, Object> attributes, T element){
        attributes.put(SCRIPT_LANGUAGE, element.getPropertyAsString(SCRIPT_LANGUAGE));
        attributes.put(PARAMETERS, element.getPropertyAsString(PARAMETERS));
        attributes.put(FILENAME, element.getPropertyAsString(FILENAME));
        attributes.put(CACHE_KEY, element.getPropertyAsString(CACHE_KEY));
        attributes.put(SCRIPT, element.getPropertyAsString(SCRIPT));
    }

}
