package jc.sugar.JiaHui.jmeter.assertion;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.assertions.CompareAssertion;
import org.apache.jmeter.assertions.SubstitutionElement;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.apache.jmeter.testelement.property.JMeterProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

@JMeterElementMapperFor(value = JMeterElementType.CompareAssertion, testGuiClass = JMeterElement.CompareAssertion)
public class CompareAssertionMapper extends JMeterElementMapperRoot<CompareAssertion> {

    public static final String WEB_COMPARE_CONTENT = "compareContent";

    public static final String WEB_COMPARE_TIME = "compareTime";

    public static final String WEB_STRINGS_TO_SKIP = "stringsToSkip";

    private static final String WEB_STRING_REGEX = "regex";

    private static final String WEB_STRING_SUBSTITUTE = "substitute";

    private CompareAssertionMapper(CompareAssertion element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public CompareAssertionMapper(Map<String, Object> attributes){
        this(new CompareAssertion(), attributes);
    }

    public CompareAssertionMapper(CompareAssertion element){
        this(element, new HashMap<>());
    }

    @Override
    public CompareAssertion fromAttributes() {
        element.setProperty(WEB_COMPARE_CONTENT, getBoolean(attributes.get(WEB_COMPARE_CONTENT)));
        element.setProperty(WEB_COMPARE_TIME, getLong(attributes.get(WEB_COMPARE_TIME)));
        List<Map<String, Object>> stringsToSkipAttributesList = (List<Map<String, Object>>) attributes.get(WEB_STRINGS_TO_SKIP);
        List<SubstitutionElement> substitutionElements = new ArrayList<>();
        for (Map<String, Object> stringsToSkipAttributes: stringsToSkipAttributesList){
            SubstitutionElement substitutionElement = new SubstitutionElement();
            substitutionElement.setRegex(getString(stringsToSkipAttributes.get(WEB_STRING_REGEX)));
            substitutionElement.setSubstitute(getString(stringsToSkipAttributes.get(WEB_STRING_SUBSTITUTE)));
            substitutionElements.add(substitutionElement);
        }
        element.setProperty(new CollectionProperty(WEB_STRINGS_TO_SKIP, substitutionElements));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Assertion);
        attributes.put(WEB_TYPE, JMeterElementType.CompareAssertion);

        attributes.put(WEB_COMPARE_CONTENT, element.getPropertyAsBoolean(WEB_COMPARE_CONTENT));
        attributes.put(WEB_COMPARE_TIME, element.getPropertyAsLong(WEB_COMPARE_TIME));

        List<Map<String, Object>> stringsToSkip = new ArrayList<>();
        for(JMeterProperty subProperty: (CollectionProperty) element.getProperty(WEB_STRINGS_TO_SKIP)){
            SubstitutionElement substitutionElement = (SubstitutionElement) subProperty.getObjectValue();
            Map<String, Object> subAttributes = new HashMap<>();
            subAttributes.put(WEB_ID, System.identityHashCode(substitutionElement));
            subAttributes.put(WEB_STRING_REGEX, substitutionElement.getRegex());
            subAttributes.put(WEB_STRING_SUBSTITUTE, substitutionElement.getSubstitute());
            stringsToSkip.add(subAttributes);
        }
        attributes.put(WEB_STRINGS_TO_SKIP, stringsToSkip);
        return attributes;
    }
}
