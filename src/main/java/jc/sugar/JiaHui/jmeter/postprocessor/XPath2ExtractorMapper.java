package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.XPath2Extractor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.XPath2Extractor, testGuiClass = JMeterElement.XPath2Extractor)
public class XPath2ExtractorMapper extends AbstractJMeterElementMapper<XPath2Extractor> {

    public static final String WEB_REF_NAME = "refName";

    public static final String WEB_XPATH_QUERY = "xpathQuery";

    public static final String WEB_MATCH_NUMBER = "matchNumber";

    public static final String WEB_DEFAULT = "default";

    public static final String WEB_NAMESPACES = "namespaces";

    public static final String WEB_FRAGMENT = "fragment";

    private XPath2ExtractorMapper(XPath2Extractor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public XPath2ExtractorMapper(Map<String, Object> attributes){
        this(new XPath2Extractor(), attributes);
    }

    public XPath2ExtractorMapper(XPath2Extractor element){
        this(element, new HashMap<>());
    }

    @Override
    public XPath2Extractor fromAttributes() {
        element.setRefName(getString(attributes.get(WEB_REF_NAME)));
        element.setXPathQuery(getString(attributes.get(WEB_XPATH_QUERY)));
        element.setMatchNumber(getString(attributes.get(WEB_MATCH_NUMBER)));
        element.setDefaultValue(getString(attributes.get(WEB_DEFAULT)));
        element.setNamespaces(getString(attributes.get(WEB_NAMESPACES)));
        element.setFragment(getBoolean(attributes.get(WEB_FRAGMENT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.XPath2Extractor);

        attributes.put(WEB_REF_NAME, element.getRefName());
        attributes.put(WEB_XPATH_QUERY, element.getXPathQuery());
        attributes.put(WEB_MATCH_NUMBER, element.getMatchNumberAsString());
        attributes.put(WEB_DEFAULT, element.getDefaultValue());
        attributes.put(WEB_NAMESPACES, element.getNamespaces());
        attributes.put(WEB_FRAGMENT, element.getFragment());

        return attributes;
    }
}
