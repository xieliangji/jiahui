package jc.sugar.JiaHui.jmeter.controller;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.control.ThroughputController;

import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

@JMeterElementMapperFor(value = JMeterElementType.ThroughputController, testGuiClass = JMeterElement.ThroughputController)
public class ThroughputControllerMapper extends AbstractJMeterElementMapper<ThroughputController> {
    public static final String WEB_STYLE = "style";

    public static final String WEB_MAX_THROUGHPUT = "maxThroughput";

    public static final String WEB_PER_THREAD = "perThread";

    public static final String WEB_PERCENT_THROUGHPUT = "percentThroughput";

    private ThroughputControllerMapper(ThroughputController element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    @Override
    public ThroughputController fromAttributes() {
        element.setStyle(getInt(attributes.get(WEB_STYLE)));
        element.setMaxThroughput(getInt(attributes.get(WEB_MAX_THROUGHPUT)));
        element.setPerThread(getBoolean(attributes.get(WEB_PER_THREAD)));
        element.setPercentThroughput(getString(attributes.get(WEB_PERCENT_THROUGHPUT)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Controller);
        attributes.put(WEB_TYPE, JMeterElementType.ThroughputController);

        attributes.put(WEB_STYLE, element.getStyle());
        attributes.put(WEB_MAX_THROUGHPUT, element.getMaxThroughput());
        attributes.put(WEB_PER_THREAD, element.isPerThread());
        attributes.put(WEB_PERCENT_THROUGHPUT, element.getPercentThroughput());

        return attributes;
    }
}
