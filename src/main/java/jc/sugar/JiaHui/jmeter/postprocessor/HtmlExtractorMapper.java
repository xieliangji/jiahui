package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.HtmlExtractor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.HtmlExtractor, testGuiClass = JMeterElement.HtmlExtractor)
public class HtmlExtractorMapper extends JMeterElementMapperRoot<HtmlExtractor> {

    public static final String WEB_EXTRACTOR_IMPL = "extractorImpl";

    public static final String WEB_REF_NAME = "refName";

    public static final String WEB_EXPR = "expr";

    public static final String WEB_ATTRIBUTE = "attribute";

    public static final String WEB_MATCH_NUMBER = "matchNumber";

    public static final String WEB_DEFAULT = "default";

    public static final String WEB_DEFAULT_EMPTY_VALUE = "defaultEmptyValue";

    private HtmlExtractorMapper(HtmlExtractor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public HtmlExtractorMapper(Map<String, Object> attributes){
        this(new HtmlExtractor(), attributes);
    }

    public HtmlExtractorMapper(HtmlExtractor element){
        this(element, new HashMap<>());
    }

    @Override
    public HtmlExtractor fromAttributes() {
        element.setExtractor(getString(attributes.get(WEB_EXTRACTOR_IMPL)));
        element.setRefName(getString(attributes.get(WEB_REF_NAME)));
        element.setExpression(getString(attributes.get(WEB_EXPR)));
        element.setAttribute(getString(attributes.get(WEB_ATTRIBUTE)));
        element.setMatchNumber(getString(attributes.get(WEB_MATCH_NUMBER)));
        element.setDefaultValue(getString(attributes.get(WEB_DEFAULT)));
        element.setDefaultEmptyValue(getBoolean(attributes.get(WEB_DEFAULT_EMPTY_VALUE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.HtmlExtractor);

        attributes.put(WEB_EXTRACTOR_IMPL, element.getExtractor());
        attributes.put(WEB_REF_NAME, element.getRefName());
        attributes.put(WEB_EXPR, element.getExpression());
        attributes.put(WEB_ATTRIBUTE, element.getAttribute());
        attributes.put(WEB_MATCH_NUMBER, element.getMatchNumberAsString());
        attributes.put(WEB_DEFAULT, element.getDefaultValue());
        attributes.put(WEB_DEFAULT_EMPTY_VALUE, element.isEmptyDefaultValue());
        return attributes;
    }
}
