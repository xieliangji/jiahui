package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.CSVDataSet;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.CSVDataSet, testGuiClass = JMeterElement.CSVDataSet)
public class CSVDataSetMapper extends AbstractJMeterElementMapper<CSVDataSet> {
    public static final String WEB_FILENAME = "filename";

    public static final String WEB_FILE_ENCODING = "fileEncoding";

    public static final String WEB_VARIABLE_NAMES = "variableNames";

    public static final String WEB_IGNORE_FIRST_LINE = "ignoreFirstLine";

    public static final String WEB_DELIMITER = "delimiter";

    public static final String WEB_QUOTED_DATA = "quotedData";

    public static final String WEB_RECYCLE = "recycle";

    public static final String WEB_STOP_THREAD = "stopThread";

    public static final String WEB_SHARE_MODE = "shareMode";


    private CSVDataSetMapper(CSVDataSet element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public CSVDataSetMapper(Map<String, Object> attributes){
        this(new CSVDataSet(), attributes);
    }

    public CSVDataSetMapper(CSVDataSet element){
        this(element, new HashMap<>());
    }

    @Override
    public CSVDataSet fromAttributes() {
        element.setProperty(WEB_FILENAME, getString(attributes.get(WEB_FILENAME)));
        element.setProperty(WEB_FILE_ENCODING, getString(attributes.get(WEB_FILE_ENCODING)));
        element.setProperty(WEB_VARIABLE_NAMES, getString(attributes.get(WEB_VARIABLE_NAMES)));
        element.setProperty(WEB_IGNORE_FIRST_LINE, getBoolean(attributes.get(WEB_IGNORE_FIRST_LINE)));
        element.setProperty(WEB_DELIMITER, getString(attributes.get(WEB_DELIMITER)));
        element.setProperty(WEB_QUOTED_DATA, getBoolean(attributes.get(WEB_QUOTED_DATA)));
        element.setProperty(WEB_RECYCLE, getBoolean(attributes.get(WEB_RECYCLE)));
        element.setProperty(WEB_STOP_THREAD, getBoolean(attributes.get(WEB_STOP_THREAD)));
        element.setProperty(WEB_SHARE_MODE, getString(attributes.get(WEB_SHARE_MODE)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.CSVDataSet);

        attributes.put(WEB_FILENAME, element.getPropertyAsString(WEB_FILENAME));
        attributes.put(WEB_FILE_ENCODING, element.getPropertyAsString(WEB_FILE_ENCODING));
        attributes.put(WEB_VARIABLE_NAMES, element.getPropertyAsString(WEB_VARIABLE_NAMES));
        attributes.put(WEB_IGNORE_FIRST_LINE, element.getPropertyAsBoolean(WEB_IGNORE_FIRST_LINE));
        attributes.put(WEB_DELIMITER, element.getPropertyAsString(WEB_DELIMITER));
        attributes.put(WEB_QUOTED_DATA, element.getPropertyAsBoolean(WEB_QUOTED_DATA));
        attributes.put(WEB_RECYCLE, element.getPropertyAsBoolean(WEB_RECYCLE));
        attributes.put(WEB_STOP_THREAD, element.getPropertyAsBoolean(WEB_STOP_THREAD));
        attributes.put(WEB_SHARE_MODE, element.getPropertyAsString(WEB_SHARE_MODE));
        return attributes;
    }
}
