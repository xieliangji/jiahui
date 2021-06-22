package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.json.jmespath.JMESPathExtractor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.JMESPathExtractor, testGuiClass = JMeterElement.JMESPathExtractor)
public class JMESPathExtractorMapper extends AbstractJMeterElementMapper<JMESPathExtractor> {

    public static final String WEB_REFERENCE_NAME = "referenceName";

    public static final String WEB_JMES_PATH_EXPR = "jmesPathExpr";

    public static final String WEB_MATCH_NUMBER = "matchNumber";

    public static final String WEB_DEFAULT_VALUE = "defaultValue";

    private JMESPathExtractorMapper(JMESPathExtractor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JMESPathExtractorMapper(Map<String, Object> attributes){
        this(new JMESPathExtractor(), attributes);
    }

    public JMESPathExtractorMapper(JMESPathExtractor element){
        this(element, new HashMap<>());
    }

    @Override
    public JMESPathExtractor fromAttributes() {
        element.setRefName(getString(attributes.get(WEB_REFERENCE_NAME)));
        element.setJmesPathExpression(getString(attributes.get(WEB_JMES_PATH_EXPR)));
        element.setMatchNumber(getString(attributes.get(WEB_MATCH_NUMBER)));
        element.setDefaultValue(getString(attributes.get(WEB_DEFAULT_VALUE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.JMESPathExtractor);

        attributes.put(WEB_REFERENCE_NAME, element.getRefName());
        attributes.put(WEB_JMES_PATH_EXPR, element.getJmesPathExpression());
        attributes.put(WEB_MATCH_NUMBER, element.getMatchNumber());
        attributes.put(WEB_DEFAULT_VALUE, element.getDefaultValue());
        return attributes;
    }
}
