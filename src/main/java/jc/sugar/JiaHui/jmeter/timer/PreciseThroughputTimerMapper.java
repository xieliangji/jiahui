package jc.sugar.JiaHui.jmeter.timer;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.timers.poissonarrivals.PreciseThroughputTimer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.PreciseThroughputTimer, testGuiClass = JMeterElement.PreciseThroughputTimer)
public class PreciseThroughputTimerMapper extends JMeterElementMapperRoot<PreciseThroughputTimer> {

    public static final String WEB_ALLOWED_THROUGHPUT_SURPLUS = "allowedThroughputSurplus";

    public static final String WEB_EXACT_LIMIT = "exactLimit";

    public static final String WEB_THROUGHPUT = "throughput";

    public static final String WEB_THROUGHPUT_PERIOD = "throughputPeriod";

    public static final String WEB_DURATION = "duration";

    public static final String WEB_BATCH_SIZE = "batchSize";

    public static final String WEB_BATCH_THREAD_DELAY = "batchThreadDelay";

    public static final String WEB_RANDOM_SEED = "randomSeed";

    private PreciseThroughputTimerMapper(PreciseThroughputTimer element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public PreciseThroughputTimerMapper(Map<String, Object> attributes){
        this(new PreciseThroughputTimer(), attributes);
    }

    public PreciseThroughputTimerMapper(PreciseThroughputTimer element){
        this(element, new HashMap<>());
    }

    @Override
    public PreciseThroughputTimer fromAttributes() {
        String[] attrNames = new String[]{WEB_ALLOWED_THROUGHPUT_SURPLUS, WEB_EXACT_LIMIT, WEB_THROUGHPUT, WEB_THROUGHPUT_PERIOD, WEB_DURATION, WEB_BATCH_SIZE, WEB_BATCH_THREAD_DELAY, WEB_RANDOM_SEED};
        for(String attrName: attrNames){
            element.setProperty(attrName, getString(attributes.get(attrName)));
        }
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        String[] attrNames = new String[]{WEB_ALLOWED_THROUGHPUT_SURPLUS, WEB_EXACT_LIMIT, WEB_THROUGHPUT, WEB_THROUGHPUT_PERIOD, WEB_DURATION, WEB_BATCH_SIZE, WEB_BATCH_THREAD_DELAY, WEB_RANDOM_SEED};

        attributes.put(WEB_CATEGORY, JMeterElementCategory.Timer);
        attributes.put(WEB_TYPE, JMeterElementType.PreciseThroughputTimer);

        for(String attrName: attrNames){
            attributes.put(attrName, element.getPropertyAsString(attrName));
        }
        return attributes;
    }
}
