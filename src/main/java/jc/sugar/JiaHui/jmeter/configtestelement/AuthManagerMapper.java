package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.JMeterElementCategory;
import jc.sugar.JiaHui.jmeter.JMeterElementMapperRoot;
import jc.sugar.JiaHui.jmeter.JMeterElementType;
import org.apache.jmeter.protocol.http.control.AuthManager;
import org.apache.jmeter.protocol.http.control.Authorization;
import org.apache.jmeter.testelement.property.JMeterProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

public class AuthManagerMapper extends JMeterElementMapperRoot<AuthManager> {
    // +JMX key names - copy from Authorization
    public static final String MECHANISM = "Authorization.mechanism";

    // +WEB key names - do not change.
    public static final String WEB_CLEAR_EACH_ITERATION = "clearEachIteration";

    public static final String WEB_CONTROLLED_BY_THREAD_GROUP = "controlledByThreadGroup";

    public static final String WEB_AUTH_LIST = "authList";

    public static final String WEB_AUTH_URL = "url";

    public static final String WEB_AUTH_USERNAME = "username";

    public static final String WEB_AUTH_PASSWORD = "password";

    public static final String WEB_AUTH_DOMAIN = "domain";

    public static final String WEB_AUTH_REALM = "realm";

    public static final String WEB_AUTH_MECHANISM = "mechanism";

    private AuthManagerMapper(AuthManager element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    @Override
    public AuthManager fromAttributes() {
        element.setClearEachIteration(getBoolean(attributes.get(WEB_CLEAR_EACH_ITERATION)));
        element.setControlledByThread(getBoolean(attributes.get(WEB_CONTROLLED_BY_THREAD_GROUP)));

        List<Map<String, Object>> authList = (List<Map<String, Object>>) attributes.get(WEB_AUTH_LIST);
        for(Map<String, Object> auth: authList){
            Authorization authorization = new Authorization();
            authorization.setURL(getString(auth.get(WEB_AUTH_URL)));
            authorization.setUser(getString(auth.get(WEB_AUTH_USERNAME)));
            authorization.setPass(getString(auth.get(WEB_AUTH_PASSWORD)));
            authorization.setDomain(getString(auth.get(WEB_AUTH_DOMAIN)));
            authorization.setRealm(getString(auth.get(WEB_AUTH_REALM)));
            authorization.setProperty(MECHANISM, getString(auth.get(WEB_AUTH_MECHANISM)));
            element.addAuth(authorization);
        }

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.AuthManager);

        attributes.put(WEB_CLEAR_EACH_ITERATION, element.getClearEachIteration());
        attributes.put(WEB_CONTROLLED_BY_THREAD_GROUP, element.getControlledByThread());

        List<Map<String, Object>> authList = new ArrayList<>();
        for(JMeterProperty auth: element.getAuthObjects()){
            Authorization authorization = (Authorization) auth.getObjectValue();
            Map<String, Object> authAttributes = new HashMap<>();
            authAttributes.put(WEB_ID, System.identityHashCode(authorization));
            authAttributes.put(WEB_AUTH_URL, authorization.getURL());
            authAttributes.put(WEB_AUTH_USERNAME, authorization.getURL());
            authAttributes.put(WEB_AUTH_PASSWORD, authorization.getPass());
            authAttributes.put(WEB_AUTH_DOMAIN, authorization.getDomain());
            authAttributes.put(WEB_AUTH_REALM, authorization.getRealm());
            authAttributes.put(WEB_AUTH_MECHANISM, authorization.getMechanism().name());
            authList.add(authAttributes);
        }
        attributes.put(WEB_AUTH_LIST, authList);

        return attributes;
    }
}
