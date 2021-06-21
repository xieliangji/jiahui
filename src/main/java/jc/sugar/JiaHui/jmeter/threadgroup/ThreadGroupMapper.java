package jc.sugar.JiaHui.jmeter.threadgroup;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.controller.LoopControllerMapper;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.TestElementProperty;
import org.apache.jmeter.threads.PostThreadGroup;
import org.apache.jmeter.threads.SetupThreadGroup;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.PostThreadGroupGui;
import org.apache.jmeter.threads.gui.SetupThreadGroupGui;
import org.apache.jmeter.threads.gui.ThreadGroupGui;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

/**
 * 2021/5/25 17:38
 * Code by 谢良基
 */
@JMeterElementMapperFor(value = JMeterElementType.ThreadGroup, testGuiClass = JMeterElement.ThreadGroup)
public class ThreadGroupMapper extends JMeterElementMapperRoot<ThreadGroup> {
    //+ MAP key names - do not change the string values
    public static final String WEB_RAMP_TIME = "rampTime";

    public static final String WEB_DELAYED_START = "delayedStart";

    public static final String WEB_SCHEDULER = "scheduler";

    public static final String WEB_DURATION = "duration";

    public static final String WEB_DELAY = "delay";

    public static final String WEB_NUM_THREADS = "numThreads";

    public static final String WEB_ON_SAMPLE_ERROR = "onSampleError";

    public static final String WEB_IS_SAME_USER_ON_NEXT_ITERATION = "sameUserOnNextIteration";

    private ThreadGroupMapper(ThreadGroup element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public ThreadGroupMapper(Map<String, Object> attributes){
        this(new ThreadGroup(), attributes);
    }

    public ThreadGroupMapper(ThreadGroup element){
        this(element, new HashMap<>());
    }

    @Override
    public ThreadGroup fromAttributes() {
        setThreadGroupElement(element, attributes);
        element.setProperty(ThreadGroup.DELAYED_START, getBoolean(attributes.get(WEB_DELAYED_START)));

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ThreadGroup);
        attributes.put(WEB_TYPE, JMeterElementType.ThreadGroup);

        setThreadGroupAttributes(attributes, element);
        attributes.put(WEB_DELAYED_START, element.getPropertyAsBoolean(ThreadGroup.DELAYED_START));
        return attributes;
    }

    public static <T extends  ThreadGroup> void setThreadGroupElement(T element, Map<String, Object> attributes){
        element.setProperty(ThreadGroup.ON_SAMPLE_ERROR, getString(attributes.get(WEB_ON_SAMPLE_ERROR)));
        element.setProperty(ThreadGroup.IS_SAME_USER_ON_NEXT_ITERATION, getBoolean(attributes.get(WEB_IS_SAME_USER_ON_NEXT_ITERATION)));
        element.setProperty(ThreadGroup.NUM_THREADS, getString(attributes.get(WEB_NUM_THREADS)));
        element.setProperty(ThreadGroup.RAMP_TIME, getString(attributes.get(WEB_RAMP_TIME)));
        element.setProperty(ThreadGroup.SCHEDULER, getBoolean(attributes.get(WEB_SCHEDULER)));
        element.setProperty(ThreadGroup.DURATION, getString(attributes.get(WEB_DURATION)));
        element.setProperty(ThreadGroup.DELAY, getString(attributes.get(WEB_DELAY)));

        LoopControllerMapper loopControllerMapper = new LoopControllerMapper(attributes);
        LoopController loopController = loopControllerMapper.fromAttributes();
        element.setProperty(new TestElementProperty(ThreadGroup.MAIN_CONTROLLER, loopController));
    }

    public static <T extends ThreadGroup> void setThreadGroupAttributes(Map<String, Object> attributes, T element){
        attributes.put(WEB_ON_SAMPLE_ERROR, element.getPropertyAsString(ThreadGroup.ON_SAMPLE_ERROR));
        attributes.put(WEB_IS_SAME_USER_ON_NEXT_ITERATION, element.getPropertyAsBoolean(ThreadGroup.IS_SAME_USER_ON_NEXT_ITERATION));
        attributes.put(WEB_NUM_THREADS, element.getPropertyAsString(ThreadGroup.NUM_THREADS));
        attributes.put(WEB_RAMP_TIME, element.getPropertyAsString(ThreadGroup.RAMP_TIME));
        attributes.put(WEB_SCHEDULER, element.getPropertyAsBoolean(ThreadGroup.SCHEDULER));
        attributes.put(WEB_DURATION, element.getPropertyAsString(ThreadGroup.DURATION));
        attributes.put(WEB_DELAY, element.getPropertyAsString(ThreadGroup.DELAY));

        LoopController loopController = (LoopController) element.getSamplerController();
        LoopControllerMapper loopControllerMapper = new LoopControllerMapper(loopController);
        Map<String, Object> controllerAttributes = loopControllerMapper.toAttributes();
        attributes.put(LoopControllerMapper.WEB_LOOPS, controllerAttributes.get(LoopControllerMapper.WEB_LOOPS));
        attributes.put(LoopControllerMapper.WEB_CONTINUE_FOREVER, controllerAttributes.get(LoopControllerMapper.WEB_CONTINUE_FOREVER));
    }
}
