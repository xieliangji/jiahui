package jc.sugar.JiaHui.jmeter.threadgroup;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.threads.PostThreadGroup;

import java.util.HashMap;
import java.util.Map;

@JMeterElementMapperFor(value = JMeterElementType.PostThreadGroup, testGuiClass = JMeterElement.PostThreadGroup)
public class PostThreadGroupMapper extends JMeterElementMapperRoot<PostThreadGroup> {
    private PostThreadGroupMapper(PostThreadGroup element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public PostThreadGroupMapper(Map<String, Object> attributes){
        this(new PostThreadGroup(), attributes);
    }

    public PostThreadGroupMapper(PostThreadGroup element){
        this(element, new HashMap<>());
    }

    @Override
    public PostThreadGroup fromAttributes() {
        ThreadGroupMapper.setThreadGroupElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ThreadGroup);
        attributes.put(WEB_TYPE, JMeterElementType.PostThreadGroup);
        ThreadGroupMapper.setThreadGroupAttributes(attributes, element);
        return attributes;
    }
}
