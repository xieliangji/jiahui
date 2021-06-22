package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.LoginConfig;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.KeystoreConfig, testGuiClass = JMeterElement.LoginConfig)
public class LoginConfigMapper extends AbstractJMeterElementMapper<LoginConfig> {

    public static final String WEB_USERNAME = "username";

    public static final String WEB_PASSWORD = "password";

    private LoginConfigMapper(LoginConfig element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public LoginConfigMapper(Map<String, Object> attributes){
        this(new LoginConfig(), attributes);
    }

    public LoginConfigMapper(LoginConfig element){
        this(element, new HashMap<>());
    }

    @Override
    public LoginConfig fromAttributes() {
        element.setUsername(getString(attributes.get(WEB_USERNAME)));
        element.setPassword(getString(attributes.get(WEB_PASSWORD)));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.LoginConfig);

        attributes.put(WEB_USERNAME, element.getUsername());
        attributes.put(WEB_PASSWORD, element.getPassword());
        return attributes;
    }
}
