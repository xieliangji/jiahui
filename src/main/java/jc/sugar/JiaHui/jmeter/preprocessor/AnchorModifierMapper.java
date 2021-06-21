package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.modifier.AnchorModifier;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.AnchorModifier, testGuiClass = JMeterElement.AnchorModifier)
public class AnchorModifierMapper extends JMeterElementMapperRoot<AnchorModifier> {

    private AnchorModifierMapper(AnchorModifier element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public AnchorModifierMapper(Map<String, Object> attributes){
        this(new AnchorModifier(), attributes);
    }

    public AnchorModifierMapper(AnchorModifier element){
        this(element, new HashMap<>());
    }

    @Override
    public AnchorModifier fromAttributes() {
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.AnchorModifier);
        return attributes;
    }
}
