package jc.sugar.JiaHui.jmeter.postprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.reporters.ResultAction;
import org.apache.jmeter.testelement.OnErrorTestElement;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getInt;

@JMeterElementMapperFor(value = JMeterElementType.ResultAction, testGuiClass = JMeterElement.ResultAction)
public class ResultActionMapper extends JMeterElementMapperRoot<ResultAction> {

    public static final String WEB_ACTION = "action";

    private ResultActionMapper(ResultAction element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ResultActionMapper(Map<String, Object> attributes){
        this(new ResultAction(), attributes);
    }

    public ResultActionMapper(ResultAction element){
        this(element, new HashMap<>());
    }

    @Override
    public ResultAction fromAttributes() {
        element.setProperty(OnErrorTestElement.ON_ERROR_ACTION, getInt(attributes.get(WEB_ACTION)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Postprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.ResultAction);

        attributes.put(WEB_ACTION, element.getErrorAction());
        return attributes;
    }
}
