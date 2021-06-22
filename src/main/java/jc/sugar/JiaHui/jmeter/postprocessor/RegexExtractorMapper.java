package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.RegexExtractor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.RegexExtractor, testGuiClass = JMeterElement.RegexExtractor)
public class RegexExtractorMapper extends JMeterElementMapperRoot<RegexExtractor> {

    // +JMX useHeaders key
    private static final String MATCH_AGAINST = "RegexExtractor.useHeaders";

    public static final String WEB_USE_HEADERS = "useHeaders";

    public static final String WEB_REF_NAME = "refName";

    public static final String WEB_REGEX = "regex";

    public static final String WEB_TEMPLATE = "template";

    public static final String WEB_MATCH_NUMBER = "matchNumber";

    public static final String WEB_DEFAULT = "default";

    public static final String WEB_DEFAULT_EMPTY_VALUE = "defaultEmptyValue";


    private RegexExtractorMapper(RegexExtractor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public RegexExtractorMapper(Map<String, Object> attributes){
        this(new RegexExtractor(), attributes);
    }

    public RegexExtractorMapper(RegexExtractor element){
        this(element, new HashMap<>());
    }

    @Override
    public RegexExtractor fromAttributes() {
        element.setUseField(getString(attributes.get(WEB_USE_HEADERS)));
        element.setRefName(getString(attributes.get(WEB_REF_NAME)));
        element.setRegex(getString(attributes.get(WEB_REGEX)));
        element.setTemplate(getString(attributes.get(WEB_TEMPLATE)));
        element.setMatchNumber(getString(attributes.get(WEB_MATCH_NUMBER)));
        element.setDefaultValue(getString(attributes.get(WEB_DEFAULT)));
        element.setDefaultEmptyValue(getBoolean(attributes.get(WEB_DEFAULT_EMPTY_VALUE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.RegexExtractor);

        attributes.put(WEB_USE_HEADERS, element.getPropertyAsString(MATCH_AGAINST));
        attributes.put(WEB_REF_NAME, element.getRefName());
        attributes.put(WEB_REGEX, element.getRegex());
        attributes.put(WEB_TEMPLATE, element.getTemplate());
        attributes.put(WEB_MATCH_NUMBER, element.getMatchNumberAsString());
        attributes.put(WEB_DEFAULT, element.getDefaultValue());
        attributes.put(WEB_DEFAULT_EMPTY_VALUE, element.isEmptyDefaultValue());

        return attributes;
    }
}
