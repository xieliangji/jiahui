package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.tcp.sampler.TCPSampler;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.testelement.TestElement;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.TCPSampler, testGuiClass = JMeterElement.TCPSampler)
public class TCPSamplerMapper extends AbstractJMeterElementMapper<TCPSampler> {
    public static final String WEB_CLASSNAME = "className";

    public static final String WEB_SERVER = "server";

    public static final String WEB_RE_USE_CONNECTION = "reUseConnection";

    public static final String WEB_TCP_PORT = "port";

    public static final String WEB_NODELAY = "noDelay";

    public static final String WEB_TIMEOUT = "timeout";

    public static final String WEB_C_TIMEOUT = "cTimeout";

    public static final String WEB_REQUEST = "request";

    public static final String WEB_CLOSE_CONNECTION = "closeConnection";

    public static final String WEB_SO_LINGER = "soLinger";

    public static final String WEB_EOL_BYTE = "eolByte";

    public static final String WEB_USERNAME = "username";

    public static final String WEB_PASSWORD = "password";

    private TCPSamplerMapper(TCPSampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public TCPSamplerMapper(Map<String, Object> attributes){
        this(new TCPSampler(), attributes);
    }

    public TCPSamplerMapper(TCPSampler element){
        this(element, new HashMap<>());
    }

    @Override
    public TCPSampler fromAttributes() {
        setTcpElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.TCPSampler);
        setTcpAttributes(attributes, element);
        return attributes;
    }

    public static <T extends TestElement> void setTcpElement(T element, Map<String, Object> attributes){
        element.setProperty(TCPSampler.CLASSNAME, getString(attributes.get(WEB_CLASSNAME)));
        element.setProperty(TCPSampler.SERVER, getString(attributes.get(WEB_SERVER)));
        element.setProperty(TCPSampler.RE_USE_CONNECTION, getBoolean(attributes.get(WEB_RE_USE_CONNECTION)));
        element.setProperty(TCPSampler.PORT, getString(attributes.get(WEB_TCP_PORT)));
        element.setProperty(TCPSampler.NODELAY, getBoolean(attributes.get(WEB_NODELAY)));
        element.setProperty(TCPSampler.TIMEOUT, getString(attributes.get(WEB_TIMEOUT)));
        element.setProperty(TCPSampler.TIMEOUT_CONNECT, getString(attributes.get(WEB_C_TIMEOUT)));
        element.setProperty(TCPSampler.REQUEST, getString(attributes.get(WEB_REQUEST)));
        element.setProperty(TCPSampler.CLOSE_CONNECTION, getBoolean(attributes.get(WEB_CLOSE_CONNECTION)));
        element.setProperty(TCPSampler.SO_LINGER, getString(attributes.get(WEB_SO_LINGER)));
        element.setProperty(TCPSampler.EOL_BYTE, getString(attributes.get(WEB_EOL_BYTE)));
        if(element instanceof Sampler){
            element.setProperty(ConfigTestElement.USERNAME, getString(attributes.get(WEB_USERNAME)));
            element.setProperty(ConfigTestElement.PASSWORD, getString(attributes.get(WEB_PASSWORD)));
        }
    }

    public static <T extends TestElement> void setTcpAttributes(Map<String, Object> attributes, T element){
        attributes.put(WEB_CLASSNAME, element.getPropertyAsString(TCPSampler.CLASSNAME));
        attributes.put(WEB_SERVER, element.getPropertyAsString(TCPSampler.SERVER));
        attributes.put(WEB_RE_USE_CONNECTION, element.getPropertyAsBoolean(TCPSampler.RE_USE_CONNECTION));
        attributes.put(WEB_TCP_PORT, element.getPropertyAsString(TCPSampler.PORT));
        attributes.put(WEB_NODELAY, element.getPropertyAsBoolean(TCPSampler.NODELAY));
        attributes.put(WEB_TIMEOUT, element.getPropertyAsString(TCPSampler.TIMEOUT));
        attributes.put(WEB_C_TIMEOUT, element.getPropertyAsString(TCPSampler.TIMEOUT_CONNECT));
        attributes.put(WEB_REQUEST, element.getPropertyAsString(TCPSampler.REQUEST));
        attributes.put(WEB_CLOSE_CONNECTION, element.getPropertyAsBoolean(TCPSampler.CLOSE_CONNECTION));
        attributes.put(WEB_SO_LINGER, element.getPropertyAsString(TCPSampler.SO_LINGER));
        attributes.put(WEB_EOL_BYTE, element.getPropertyAsString(TCPSampler.EOL_BYTE));
        if(element instanceof Sampler){
            attributes.put(WEB_USERNAME, element.getPropertyAsString(ConfigTestElement.USERNAME));
            attributes.put(WEB_PASSWORD, element.getPropertyAsString(ConfigTestElement.PASSWORD));
        }
    }
}
