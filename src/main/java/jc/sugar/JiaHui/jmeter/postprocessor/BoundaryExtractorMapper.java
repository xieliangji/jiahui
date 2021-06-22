package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.BoundaryExtractor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.BoundaryExtractor, testGuiClass = JMeterElement.BoundaryExtractor)
public class BoundaryExtractorMapper extends AbstractJMeterElementMapper<BoundaryExtractor> {

    // +JMX useHeaders key
    public static final String MATCH_AGAINST = "BoundaryExtractor.useHeaders";

    public static final String WEB_USE_HEADERS = "useHeaders";

    public static final String WEB_REF_NAME = "refName";

    public static final String WEB_LBOUNDARY = "lboundary";

    public static final String WEB_RBOUNDARY = "rboundary";

    public static final String WEB_MATCH_NUMBER = "matchNumber";

    public static final String WEB_DEFAULT = "default";

    public static final String WEB_DEFAULT_EMPTY_VALUE = "defaultEmptyValue";

    private BoundaryExtractorMapper(BoundaryExtractor element, Map<String, Object> attributes) {
        super(element, attributes);
    }


    public BoundaryExtractorMapper(Map<String, Object> attributes){
        this(new BoundaryExtractor(), attributes);
    }

    public BoundaryExtractorMapper(BoundaryExtractor element){
        this(element, new HashMap<>());
    }

    @Override
    public BoundaryExtractor fromAttributes() {
        element.setUseField(getString(attributes.get(WEB_USE_HEADERS)));
        element.setRefName(getString(attributes.get(WEB_REF_NAME)));
        element.setLeftBoundary(getString(attributes.get(WEB_LBOUNDARY)));
        element.setRightBoundary(getString(attributes.get(WEB_RBOUNDARY)));
        element.setMatchNumber(getString(attributes.get(WEB_MATCH_NUMBER)));
        element.setDefaultValue(getString(attributes.get(WEB_DEFAULT)));
        element.setDefaultEmptyValue(getBoolean(attributes.get(WEB_DEFAULT_EMPTY_VALUE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.BoundaryExtractor);

        attributes.put(WEB_USE_HEADERS, element.getPropertyAsString(MATCH_AGAINST));
        attributes.put(WEB_REF_NAME, element.getRefName());
        attributes.put(WEB_LBOUNDARY, element.getLeftBoundary());
        attributes.put(WEB_RBOUNDARY, element.getRightBoundary());
        attributes.put(WEB_MATCH_NUMBER, element.getMatchNumberAsString());
        attributes.put(WEB_DEFAULT, element.getDefaultValue());
        attributes.put(WEB_DEFAULT_EMPTY_VALUE, element.isEmptyDefaultValue());

        return attributes;
    }
}
