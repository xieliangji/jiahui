package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.modifier.RegExUserParameters;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.RegExUserParameters, testGuiClass = JMeterElement.RegExUserParameters)
public class RegExUserParametersMapper extends JMeterElementMapperRoot<RegExUserParameters> {

    public static final String WEB_REGEX_REF_NAME = "regexRefName";

    public static final String WEB_PARAM_NAMES_GR_NR = "paramNamesGrNr";

    public static final String WEB_PARAM_VALUES_GR_NR = "paramValuesGrNr";

    private RegExUserParametersMapper(RegExUserParameters element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public RegExUserParametersMapper(Map<String, Object> attributes){
        this(new RegExUserParameters(), attributes);
    }

    public RegExUserParametersMapper(RegExUserParameters element){
        this(element, new HashMap<>());
    }

    @Override
    public RegExUserParameters fromAttributes() {
        element.setRegExRefName(getString(attributes.get(WEB_REGEX_REF_NAME)));
        element.setRegExParamNamesGrNr(getString(attributes.get(WEB_PARAM_NAMES_GR_NR)));
        element.setRegExParamValuesGrNr(getString(attributes.get(WEB_PARAM_VALUES_GR_NR)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.RegExUserParameters);

        attributes.put(WEB_REGEX_REF_NAME, element.getRegExRefName());
        attributes.put(WEB_PARAM_NAMES_GR_NR, element.getRegParamNamesGrNr());
        attributes.put(WEB_PARAM_VALUES_GR_NR, element.getRegExParamValuesGrNr());
        return attributes;
    }
}
