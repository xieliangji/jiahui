package jc.sugar.JiaHui.jmeter.configtestelement;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.control.DNSCacheManager;
import org.apache.jmeter.protocol.http.control.StaticHost;
import org.apache.jmeter.testelement.property.JMeterProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.DNSCacheManager, testGuiClass = JMeterElement.DNSCacheManager)
public class DNSCacheManagerMapper extends AbstractJMeterElementMapper<DNSCacheManager> {

    public static final String WEB_CLEAR_EACH_ITERATION = "clearEachIteration";

    public static final String WEB_IS_CUSTOM_RESOLVER = "isCustomResolver";

    public static final String WEB_SERVERS = "servers";

    public static final String WEB_HOSTS = "hosts";

    public static final String WEB_SERVER_NAME = "name";

    public static final String WEB_HOST_NAME = "name";

    public static final String WEB_HOST_ADDRESS = "address";


    private DNSCacheManagerMapper(DNSCacheManager element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public DNSCacheManagerMapper(Map<String, Object> attributes){
        this(new DNSCacheManager(), attributes);
    }

    public DNSCacheManagerMapper(DNSCacheManager element){
        this(element, new HashMap<>());
    }

    @Override
    public DNSCacheManager fromAttributes() {
        element.setClearEachIteration(getBoolean(attributes.get(WEB_CLEAR_EACH_ITERATION)));
        element.setCustomResolver(getBoolean(attributes.get(WEB_IS_CUSTOM_RESOLVER)));
        if(getBoolean(attributes.get(WEB_IS_CUSTOM_RESOLVER))){
            List<Map<String, Object>> servers = (List<Map<String, Object>>) attributes.get(WEB_SERVERS);
            List<Map<String, Object>> hosts = (List<Map<String, Object>>) attributes.get(WEB_HOSTS);
            for(Map<String, Object> server: servers){
                element.addServer(getString(server.get(WEB_SERVER_NAME)));
            }
            for(Map<String, Object> host: hosts){
                element.addHost(getString(host.get(WEB_HOST_NAME)), getString(host.get(WEB_HOST_ADDRESS)));
            }
        }
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.ConfigElement);
        attributes.put(WEB_TYPE, JMeterElementType.DNSCacheManager);

        attributes.put(WEB_CLEAR_EACH_ITERATION, element.isClearEachIteration());
        attributes.put(WEB_IS_CUSTOM_RESOLVER, element.isClearEachIteration());
        List<Map<String, Object>> serverList = new ArrayList<>();
        for(JMeterProperty serverProperty: element.getServers()){
            Map<String, Object> server = new HashMap<>();
            server.put(WEB_ID, System.identityHashCode(serverProperty));
            server.put(WEB_SERVER_NAME, serverProperty.getStringValue());
            serverList.add(server);
        }
        attributes.put(WEB_SERVERS, serverList);
        List<Map<String, Object>> hostList = new ArrayList<>();
        for(JMeterProperty hostProperty: element.getHosts()){
            StaticHost host = (StaticHost) hostProperty.getObjectValue();
            Map<String, Object> hostAttributes = new HashMap<>();
            hostAttributes.put(WEB_ID, System.identityHashCode(hostProperty));
            hostAttributes.put(WEB_HOST_NAME, host.getName());
            hostAttributes.put(WEB_HOST_ADDRESS, host.getAddress());
            hostList.add(hostAttributes);
        }
        attributes.put(WEB_HOSTS, hostList);


        return attributes;
    }
}
