package jc.sugar.JiaHui.jmeter.threadgroup;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.threads.SetupThreadGroup;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.SetupThreadGroup, testGuiClass = JMeterElement.SetupThreadGroup)
public class SetupThreadGroupMapper extends JMeterElementMapperRoot<SetupThreadGroup> {
    private SetupThreadGroupMapper(SetupThreadGroup element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public SetupThreadGroupMapper(Map<String, Object> attributes){
        this(new SetupThreadGroup(), attributes);
    }

    public SetupThreadGroupMapper(SetupThreadGroup element){
        this(element, new HashMap<>());
    }

    @Override
    public SetupThreadGroup fromAttributes() {
        ThreadGroupMapper.setThreadGroupElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ThreadGroup);
        attributes.put(WEB_TYPE, JMeterElementType.SetupThreadGroup);
        ThreadGroupMapper.setThreadGroupAttributes(attributes, element);
        return attributes;
    }
}
