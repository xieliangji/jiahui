package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.XPathExtractor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.XPathExtractor, testGuiClass = JMeterElement.XPathExtractor)
public class XPathExtractorMapper extends AbstractJMeterElementMapper<XPathExtractor> {
    public static final String WEB_TOLERANT = "tolerant";

    public static final String WEB_QUIET = "quiet";

    public static final String WEB_REPORT_ERRORS = "reportErrors";

    public static final String WEB_SHOW_WARNINGS = "showWarnings";

    public static final String WEB_FRAGMENT = "fragment";

    public static final String WEB_NAMESPACE = "namespace";

    public static final String WEB_VALIDATE = "validate";

    public static final String WEB_WHITESPACE = "whitespace";

    public static final String WEB_DOWNLOAD_DTDS = "downloadDtds";

    public static final String WEB_REF_NAME = "refName";

    public static final String WEB_XPATH_QUERY = "xpathQuery";

    public static final String WEB_MATCH_NUMBER = "matchNumber";

    public static final String WEB_DEFAULT = "default";


    private XPathExtractorMapper(XPathExtractor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public XPathExtractorMapper(Map<String, Object> attributes){
        this(new XPathExtractor(), attributes);
    }

    public XPathExtractorMapper(XPathExtractor element){
        this(element, new HashMap<>());
    }

    @Override
    public XPathExtractor fromAttributes() {
        element.setTolerant(getBoolean(attributes.get(WEB_TOLERANT)));
        element.setQuiet(getBoolean(attributes.get(WEB_QUIET)));
        element.setReportErrors(getBoolean(attributes.get(WEB_REPORT_ERRORS)));
        element.setShowWarnings(getBoolean(attributes.get(WEB_SHOW_WARNINGS)));
        element.setFragment(getBoolean(attributes.get(WEB_FRAGMENT)));
        element.setNameSpace(getBoolean(attributes.get(WEB_NAMESPACE)));
        element.setValidating(getBoolean(attributes.get(WEB_VALIDATE)));
        element.setWhitespace(getBoolean(attributes.get(WEB_WHITESPACE)));
        element.setDownloadDTDs(getBoolean(attributes.get(WEB_DOWNLOAD_DTDS)));
        element.setRefName(getString(attributes.get(WEB_REF_NAME)));
        element.setXPathQuery(getString(attributes.get(WEB_XPATH_QUERY)));
        element.setMatchNumber(getString(attributes.get(WEB_MATCH_NUMBER)));
        element.setDefaultValue(getString(attributes.get(WEB_DEFAULT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.XPathExtractor);

        attributes.put(WEB_TOLERANT, element.isTolerant());
        attributes.put(WEB_QUIET, element.isQuiet());
        attributes.put(WEB_REPORT_ERRORS, element.reportErrors());
        attributes.put(WEB_SHOW_WARNINGS, element.showWarnings());
        attributes.put(WEB_FRAGMENT, element.getFragment());
        attributes.put(WEB_NAMESPACE, element.useNameSpace());
        attributes.put(WEB_VALIDATE, element.isValidating());
        attributes.put(WEB_WHITESPACE, element.isWhitespace());
        attributes.put(WEB_DOWNLOAD_DTDS, element.isDownloadDTDs());
        attributes.put(WEB_REF_NAME, element.getRefName());
        attributes.put(WEB_XPATH_QUERY, element.getXPathQuery());
        attributes.put(WEB_MATCH_NUMBER, element.getMatchNumberAsString());
        attributes.put(WEB_DEFAULT, element.getDefaultValue());

        return attributes;
    }
}
