package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.extractor.json.jsonpath.JSONPostProcessor;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.JSONPostProcessor, testGuiClass = JMeterElement.JSONPostProcessor)
public class JSONPostProcessorMapper extends JMeterElementMapperRoot<JSONPostProcessor> {

    public static final String WEB_REFERENCE_NAMES = "referenceNames";

    public static final String WEB_JSON_PATH_EXPRS = "jsonPathExprs";

    public static final String WEB_MATCH_NUMBERS = "matchNumbers";

    public static final String WEB_DEFAULT_VALUES = "defaultValues";

    public static final String WEB_COMPUTE_CONCAT = "computeConcat";

    private JSONPostProcessorMapper(JSONPostProcessor element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public JSONPostProcessorMapper(Map<String, Object> attributes){
        this(new JSONPostProcessor(), attributes);
    }

    public JSONPostProcessorMapper(JSONPostProcessor element){
        this(element, new HashMap<>());
    }

    @Override
    public JSONPostProcessor fromAttributes() {
        element.setRefNames(getString(attributes.get(WEB_REFERENCE_NAMES)));
        element.setJsonPathExpressions(getString(attributes.get(WEB_JSON_PATH_EXPRS)));
        element.setMatchNumbers(getString(attributes.get(WEB_MATCH_NUMBERS)));
        element.setDefaultValues(getString(attributes.get(WEB_DEFAULT_VALUES)));
        element.setComputeConcatenation(getBoolean(attributes.get(WEB_COMPUTE_CONCAT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.JSONPostProcessor);

        attributes.put(WEB_REFERENCE_NAMES, element.getRefNames());
        attributes.put(WEB_JSON_PATH_EXPRS, element.getJsonPathExpressions());
        attributes.put(WEB_MATCH_NUMBERS, element.getMatchNumbers());
        attributes.put(WEB_DEFAULT_VALUES, element.getDefaultValues());
        attributes.put(WEB_COMPUTE_CONCAT, element.getComputeConcatenation());

        return attributes;
    }
}
