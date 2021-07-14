package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.HTMLAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

/**
 * @Code 谢良基 2021/7/14
 */
@JMeterElementMapperFor(value = JMeterElementType.HTMLAssertion, testGuiClass = JMeterElement.HTMLAssertion)
public class HTMLAssertionMapper extends AbstractJMeterElementMapper<HTMLAssertion> {

    public static final String WEB_HTML_ASSERTION_DOC_TYPE = "htmlAssertionDocType";

    public static final String WEB_HTML_ASSERTION_FORMAT = "htmlAssertionFormat";

    public static final String WEB_HTML_ASSERTION_ERROR_ONLY = "htmlAssertionErrorOnly";

    public static final String WEB_HTML_ASSERTION_ERROR_THRESHOLD = "htmlAssertionErrorThreshold";

    public static final String WEB_HTML_ASSERTION_WARNING_THRESHOLD = "htmlAssertionWarningThreshold";

    public static final String WEB_HTML_ASSERTION_FILENAME = "htmlAssertionFilename";

    private HTMLAssertionMapper(HTMLAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public HTMLAssertionMapper(Map<String, Object> attributes){
        this(new HTMLAssertion(), attributes);
    }

    public HTMLAssertionMapper(HTMLAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public HTMLAssertion fromAttributes() {
        element.setProperty(HTMLAssertion.DOCTYPE_KEY, getString(attributes.get(WEB_HTML_ASSERTION_DOC_TYPE)));
        element.setProperty(HTMLAssertion.FORMAT_KEY, getInt(attributes.get(WEB_HTML_ASSERTION_FORMAT)));
        element.setProperty(HTMLAssertion.ERRORS_ONLY_KEY, getBoolean(attributes.get(WEB_HTML_ASSERTION_ERROR_ONLY)));
        element.setProperty(HTMLAssertion.ERROR_THRESHOLD_KEY, getLong(attributes.get(WEB_HTML_ASSERTION_ERROR_THRESHOLD)));
        element.setProperty(HTMLAssertion.WARNING_THRESHOLD_KEY, getLong(attributes.get(WEB_HTML_ASSERTION_WARNING_THRESHOLD)));
        element.setProperty(HTMLAssertion.FILENAME_KEY, getString(attributes.get(WEB_HTML_ASSERTION_FILENAME)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.HTMLAssertion);

        attributes.put(WEB_HTML_ASSERTION_DOC_TYPE, element.getDoctype());
        attributes.put(WEB_HTML_ASSERTION_FILENAME, element.getFilename());
        attributes.put(WEB_HTML_ASSERTION_ERROR_ONLY, element.isErrorsOnly());
        attributes.put(WEB_HTML_ASSERTION_FORMAT, element.getPropertyAsInt(HTMLAssertion.FORMAT_KEY));
        attributes.put(WEB_HTML_ASSERTION_ERROR_THRESHOLD, element.getErrorThreshold());
        attributes.put(WEB_HTML_ASSERTION_WARNING_THRESHOLD, element.getWarningThreshold());

        return attributes;
    }
}
