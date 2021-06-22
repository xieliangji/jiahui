package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.XPathAssertion;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.XPathAssertion, testGuiClass = JMeterElement.XPathAssertion)
public class XPathAssertionMapper extends AbstractJMeterElementMapper<XPathAssertion> {
    public static final String WEB_TOLERANT = "tolerant";

    public static final String WEB_QUIET = "quiet";

    public static final String WEB_REPORT_ERRORS = "reportErrors";

    public static final String WEB_SHOW_WARNINGS = "showWarnings";

    public static final String WEB_FRAGMENT = "fragment";

    public static final String WEB_NAMESPACE = "namespace";

    public static final String WEB_VALIDATE = "validate";

    public static final String WEB_WHITESPACE = "whitespace";

    public static final String WEB_DOWNLOAD_DTDS = "downloadDtds";

    public static final String WEB_NEGATE = "negate";

    public static final String WEB_XPATH = "xpath";

    private XPathAssertionMapper(XPathAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public XPathAssertionMapper(Map<String, Object> attributes){
        this(new XPathAssertion(), attributes);
    }

    public XPathAssertionMapper(XPathAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public XPathAssertion fromAttributes() {
        element.setTolerant(getBoolean(attributes.get(WEB_TOLERANT)));
        element.setQuiet(getBoolean(attributes.get(WEB_QUIET)));
        element.setReportErrors(getBoolean(attributes.get(WEB_REPORT_ERRORS)));
        element.setShowWarnings(getBoolean(attributes.get(WEB_SHOW_WARNINGS)));
        element.setNamespace(getBoolean(attributes.get(WEB_NAMESPACE)));
        element.setValidating(getBoolean(attributes.get(WEB_VALIDATE)));
        element.setWhitespace(getBoolean(attributes.get(WEB_WHITESPACE)));
        element.setDownloadDTDs(getBoolean(attributes.get(WEB_DOWNLOAD_DTDS)));
        element.setNegated(getBoolean(attributes.get(WEB_NEGATE)));
        element.setXPathString(getString(attributes.get(WEB_XPATH)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.XPathAssertion);

        attributes.put(WEB_TOLERANT, element.isTolerant());
        attributes.put(WEB_QUIET, element.isQuiet());
        attributes.put(WEB_REPORT_ERRORS, element.reportErrors());
        attributes.put(WEB_SHOW_WARNINGS, element.showWarnings());
        attributes.put(WEB_NAMESPACE, element.isNamespace());
        attributes.put(WEB_VALIDATE, element.isValidating());
        attributes.put(WEB_WHITESPACE, element.isWhitespace());
        attributes.put(WEB_DOWNLOAD_DTDS, element.isDownloadDTDs());
        attributes.put(WEB_NEGATE, element.isNegated());
        attributes.put(WEB_XPATH, element.getXPathString());
        return attributes;
    }
}
