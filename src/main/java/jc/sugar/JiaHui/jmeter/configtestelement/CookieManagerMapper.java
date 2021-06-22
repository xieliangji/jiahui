package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.control.Cookie;
import org.apache.jmeter.protocol.http.control.CookieManager;
import org.apache.jmeter.testelement.property.JMeterProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

@JMeterElementMapperFor(value = JMeterElementType.CookieManager, testGuiClass = JMeterElement.CookieManager)
public class CookieManagerMapper extends AbstractJMeterElementMapper<CookieManager> {

    public static final String WEB_CLEAR_EACH_ITERATION = "clearEachIteration";

    public static final String WEB_CONTROLLED_BY_THREAD = "controlledByThreadGroup";

    public static final String WEB_POLICY = "policy";

    public static final String WEB_COOKIES = "cookies";

    public static final String WEB_COOKIE_NAME = "name";

    public static final String WEB_COOKIE_VALUE = "value";

    public static final String WEB_COOKIE_DOMAIN = "domain";

    public static final String WEB_COOKIE_PATH = "path";

    public static final String WEB_COOKIE_SECURE = "secure";

    public static final String WEB_COOKIE_EXPIRES = "expires";

    public static final String WEB_COOKIE_PATH_SPECIFIED = "pathSpecified";

    public static final String WEB_COOKIE_DOMAIN_SPECIFIED = "domainSpecified";

    private CookieManagerMapper(CookieManager element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public CookieManagerMapper(Map<String, Object> attributes){
        this(new CookieManager(), attributes);
    }

    public CookieManagerMapper(CookieManager element){
        this(element, new HashMap<>());
    }


    @Override
    public CookieManager fromAttributes() {
        element.setClearEachIteration(getBoolean(attributes.get(WEB_CLEAR_EACH_ITERATION)));
        element.setControlledByThread(getBoolean(attributes.get(WEB_CONTROLLED_BY_THREAD)));
        element.setCookiePolicy(getString(attributes.get(WEB_POLICY)));

        List<Map<String, Object>> cookieAttributesList = (List<Map<String, Object>>) attributes.get(WEB_COOKIES);
        for(Map<String, Object> cookieAttributes: cookieAttributesList){
            Cookie cookie = new Cookie(
                    getString(cookieAttributes.get(WEB_COOKIE_NAME)),
                    getString(cookieAttributes.get(WEB_COOKIE_VALUE)),
                    getString(cookieAttributes.get(WEB_COOKIE_DOMAIN)),
                    getString(cookieAttributes.get(WEB_COOKIE_PATH)),
                    getBoolean(cookieAttributes.get(WEB_COOKIE_SECURE)),
                    getLong(cookieAttributes.get(WEB_COOKIE_EXPIRES)),
                    getBoolean(cookieAttributes.get(WEB_COOKIE_PATH_SPECIFIED)),
                    getBoolean(cookieAttributes.get(WEB_COOKIE_DOMAIN_SPECIFIED))
            );
            element.add(cookie);
        }

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.CookieManager);

        attributes.put(WEB_CLEAR_EACH_ITERATION, element.getClearEachIteration());
        attributes.put(WEB_CONTROLLED_BY_THREAD, element.getControlledByThread());
        attributes.put(WEB_POLICY, element.getPolicy());

        List<Map<String, Object>> cookies = new ArrayList<>();
        for (JMeterProperty jMeterProperty : element.getCookies()) {
            Map<String, Object> cookieAttributes = new HashMap<>();
            Cookie cookie = (Cookie) jMeterProperty.getObjectValue();
            cookieAttributes.put(WEB_ID, System.identityHashCode(cookie));
            cookieAttributes.put(WEB_COOKIE_NAME, cookie.getName());
            cookieAttributes.put(WEB_COOKIE_VALUE, cookie.getValue());
            cookieAttributes.put(WEB_COOKIE_DOMAIN, cookie.getDomain());
            cookieAttributes.put(WEB_COOKIE_PATH, cookie.getPath());
            cookieAttributes.put(WEB_COOKIE_EXPIRES, cookie.getExpires());
            cookieAttributes.put(WEB_COOKIE_PATH_SPECIFIED, cookie.isPathSpecified());
            cookieAttributes.put(WEB_COOKIE_DOMAIN_SPECIFIED, cookie.isDomainSpecified());
            cookies.add(cookieAttributes);
        }
        attributes.put(WEB_COOKIES, cookies);

        return attributes;
    }
}
