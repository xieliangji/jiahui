package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.KeystoreConfig;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.KeystoreConfig, testGuiClass = JMeterElement.KeystoreConfig)
public class KeystoreConfigMapper extends AbstractJMeterElementMapper<KeystoreConfig> {
    public static final String WEB_PRELOAD = "preload";

    public static final String WEB_CLIENT_CERT_ALIAS_VAR_NAME = "clientCertAliasVarName";

    public static final String WEB_START_INDEX = "startIndex";

    public static final String WEB_END_INDEX = "endIndex";

    private KeystoreConfigMapper(KeystoreConfig element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public KeystoreConfigMapper(Map<String, Object> attributes){
        this(new KeystoreConfig(), attributes);
    }

    public KeystoreConfigMapper(KeystoreConfig element){
        this(element, new HashMap<>());
    }

    @Override
    public KeystoreConfig fromAttributes() {
        element.setProperty(WEB_CLIENT_CERT_ALIAS_VAR_NAME, getString(attributes.get(WEB_CLIENT_CERT_ALIAS_VAR_NAME)));
        element.setProperty(WEB_PRELOAD, getBoolean(attributes.get(WEB_PRELOAD)));
        element.setProperty(WEB_START_INDEX, getString(attributes.get(WEB_START_INDEX)));
        element.setProperty(WEB_END_INDEX, getString(attributes.get(WEB_END_INDEX)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.KeystoreConfig);

        attributes.put(WEB_CLIENT_CERT_ALIAS_VAR_NAME, element.getPropertyAsString(WEB_CLIENT_CERT_ALIAS_VAR_NAME));
        attributes.put(WEB_PRELOAD, element.getPropertyAsBoolean(WEB_PRELOAD));
        attributes.put(WEB_START_INDEX, element.getPropertyAsString(WEB_START_INDEX));
        attributes.put(WEB_END_INDEX, element.getPropertyAsString(WEB_END_INDEX));
        return attributes;
    }
}
