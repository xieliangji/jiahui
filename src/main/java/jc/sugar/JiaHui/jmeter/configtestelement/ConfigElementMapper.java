package jc.sugar.JiaHui.jmeter.configtestelement;

/**
 * 2021/5/24 17:53
 * Code by 谢良基
 */
public class ConfigElementMapper {

    //+ JMX field names - do not change values. [HTTPDefaults Referenced From HTTPSamplerBase]


    //+ MAP key names - do not change values.
    // http
    public static final String WEB_PROTOCOL = "protocol";

    public static final String WEB_DOMAIN = "domain";

    public static final String WEB_PORT = "port";

    public static final String WEB_PATH = "path";

    public static final String WEB_CONTENT_ENCODING = "contentEncoding";

    public static final String WEB_POST_BODY_RAW = "postBodyRaw";

    public static final String WEB_ARGUMENTS = "arguments";

    public static final String WEB_IMPLEMENTATION = "implementation";

    public static final String WEB_CONNECT_TIMEOUT = "connectTimeout";

    public static final String WEB_RESPONSE_TIMEOUT = "responseTimeout";

    public static final String WEB_IMAGE_PARSER = "imageParser";

    public static final String WEB_CONCURRENT_DWN = "concurrentDwn";

    public static final String WEB_CONCURRENT_POOL = "concurrentPool";

    public static final String WEB_EMBEDDED_URL_RE = "embeddedUrlRe";

    public static final String WEB_IP_SOURCE_TYPE = "ipSourceType";

    public static final String WEB_IP_SOURCE = "ipSource";

    public static final String WEB_PROXY_SCHEME = "proxyScheme";

    public static final String WEB_PROXY_HOST = "proxyHost";

    public static final String WEB_PROXY_PORT = "proxyPort";

    public static final String WEB_PROXY_USER = "proxyUser";

    public static final String WEB_PROXY_PASS = "proxyPass";

    public static final String WEB_MD5 = "md5";


    // tcp
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

//    private ConfigElementMapper(ConfigTestElement testElement, Map<String, Object> elementAttributeMap, boolean isFromWeb) {
//        super(testElement, elementAttributeMap, isFromWeb);
//    }
//
//
//    public ConfigElementMapper(ConfigTestElement testElement){
//        this(testElement, new HashMap<>(), false);
//    }
//
//
//    public ConfigElementMapper(Map<String, Object> elementAttributeMap){
//        this(new ConfigTestElement(), elementAttributeMap, true);
//    }
//
//
//    private void setHttpDefaults(){
//        // Basic
//        testElement.setProperty(HTTPSamplerBase.PROTOCOL, getString(elementAttributeMap.get(WEB_PROTOCOL)));
//        testElement.setProperty(HTTPSamplerBase.DOMAIN, getString(elementAttributeMap.get(WEB_DOMAIN)));
//        testElement.setProperty(HTTPSamplerBase.PORT, getString(elementAttributeMap.get(WEB_PORT)));
//        testElement.setProperty(HTTPSamplerBase.PATH, getString(elementAttributeMap.get(WEB_PATH)));
//        testElement.setProperty(HTTPSamplerBase.CONTENT_ENCODING, getString(elementAttributeMap.get(WEB_CONTENT_ENCODING)));
//
//        Arguments vars = new Arguments();
//        List<Map<String, Object>> arguments = (List<Map<String, Object>>) elementAttributeMap.get(WEB_ARGUMENTS);
//        if(getBoolean(elementAttributeMap.get(WEB_POST_BODY_RAW))){
//            testElement.setProperty(HTTPSamplerBase.POST_BODY_RAW, true);
//            Map<String, Object> raw = arguments.get(0);
//            HTTPArgument rawArgument = new HTTPArgument("", getString(raw.get("value")), false);
//            rawArgument.setAlwaysEncoded(false);
//            vars.addArgument(rawArgument);
//        } else {
//            for(Map<String, Object> argument: arguments){
//                HTTPArgument var = new HTTPArgument(
//                        getString(argument.get("name")),
//                        getString(argument.get("value")),
//                        getBoolean(argument.get("alwaysEncode")),
//                        getString(argument.get("contentType"))
//                );
//                vars.addArgument(var);
//            }
//        }
//        testElement.setProperty(new TestElementProperty(HTTPSamplerBase.ARGUMENTS, vars));
//
//        // advanced
//        testElement.setProperty(HTTPSamplerBase.IMPLEMENTATION, getString(elementAttributeMap.get(WEB_IMPLEMENTATION)));
//        testElement.setProperty(HTTPSamplerBase.CONNECT_TIMEOUT, getString(elementAttributeMap.get(WEB_CONNECT_TIMEOUT)));
//        testElement.setProperty(HTTPSamplerBase.RESPONSE_TIMEOUT, getString(elementAttributeMap.get(WEB_RESPONSE_TIMEOUT)));
//        testElement.setProperty(HTTPSamplerBase.IMAGE_PARSER, getBoolean(elementAttributeMap.get(WEB_IMAGE_PARSER)));
//        testElement.setProperty(HTTPSamplerBase.CONCURRENT_DWN, getBoolean(elementAttributeMap.get(WEB_CONCURRENT_DWN)));
//        testElement.setProperty(HTTPSamplerBase.CONCURRENT_POOL, getString(elementAttributeMap.get(WEB_CONCURRENT_POOL)));
//        testElement.setProperty(HTTPSamplerBase.EMBEDDED_URL_RE, getBoolean(elementAttributeMap.get(WEB_EMBEDDED_URL_RE)));
//        testElement.setProperty(HTTPSamplerBase.IP_SOURCE_TYPE, getInt(elementAttributeMap.get(WEB_IP_SOURCE_TYPE)));
//        testElement.setProperty(HTTPSamplerBase.IP_SOURCE, getString(elementAttributeMap.get(WEB_IP_SOURCE)));
//        testElement.setProperty(HTTPSamplerBase.PROXYSCHEME, getString(elementAttributeMap.get(WEB_PROXY_SCHEME)));
//        testElement.setProperty(HTTPSamplerBase.PROXYHOST, getString(elementAttributeMap.get(WEB_PROXY_HOST)));
//        testElement.setProperty(HTTPSamplerBase.PROXYPORT, getString(elementAttributeMap.get(WEB_PROXY_PORT)));
//        testElement.setProperty(HTTPSamplerBase.PROXYUSER, getString(elementAttributeMap.get(WEB_PROXY_USER)));
//        testElement.setProperty(HTTPSamplerBase.PROXYPASS, getString(elementAttributeMap.get(WEB_PROXY_PASS)));
//        testElement.setProperty(HTTPSamplerBase.MD5, getBoolean(elementAttributeMap.get(WEB_MD5)));
//    }
//
//
//    private void setTcpConfig(){
//        testElement.setProperty(TCPSampler.CLASSNAME, getString(elementAttributeMap.get(WEB_CLASSNAME)));
//        testElement.setProperty(TCPSampler.SERVER, getString(elementAttributeMap.get(WEB_SERVER)));
//        testElement.setProperty(TCPSampler.RE_USE_CONNECTION, getBoolean(elementAttributeMap.get(WEB_RE_USE_CONNECTION)));
//        testElement.setProperty(TCPSampler.PORT, getString(elementAttributeMap.get(WEB_TCP_PORT)));
//        testElement.setProperty(TCPSampler.NODELAY, getBoolean(elementAttributeMap.get(WEB_NODELAY)));
//        testElement.setProperty(TCPSampler.TIMEOUT, getString(elementAttributeMap.get(WEB_TIMEOUT)));
//        testElement.setProperty(TCPSampler.TIMEOUT_CONNECT, getString(elementAttributeMap.get(WEB_C_TIMEOUT)));
//        testElement.setProperty(TCPSampler.REQUEST, getString(elementAttributeMap.get(WEB_REQUEST)));
//        testElement.setProperty(TCPSampler.CLOSE_CONNECTION, getBoolean(elementAttributeMap.get(WEB_CLOSE_CONNECTION)));
//        testElement.setProperty(TCPSampler.SO_LINGER, getString(elementAttributeMap.get(WEB_SO_LINGER)));
//        testElement.setProperty(TCPSampler.EOL_BYTE, getString(elementAttributeMap.get(WEB_EOL_BYTE)));
//    }
//
//
//    @Override
//    public TestElement getTestElement() {
//        String testElementGuiClass = testElement.getPropertyAsString(TestElement.GUI_CLASS);
//        if(testElementGuiClass.contains(HttpDefaultsGui.class.getSimpleName())){
//            setHttpDefaults();
//        } else if(testElementGuiClass.contains(TCPConfigGui.class.getSimpleName())){
//            setTcpConfig();
//        } else {
//            testElement = null;
//        }
//
//        return testElement;
//    }
//
//
//    @Override
//    public Map<String, Object> getElementAttributeMap() {
//        String testElementGuiClass = testElement.getPropertyAsString(TestElement.GUI_CLASS);
//        if(testElementGuiClass.contains(HttpDefaultsGui.class.getSimpleName())){
//            setHttpDefaultsMap();
//        } else if(testElementGuiClass.contains(TCPConfigGui.class.getSimpleName())){
//            setTcpConfigMap();
//        } else {
//            elementAttributeMap = null;
//        }
//
//        return elementAttributeMap;
//    }
//
//
//    private void setHttpDefaultsMap(){
//        elementAttributeMap.put(WEB_PROTOCOL, testElement.getPropertyAsString(HTTPSamplerBase.PROTOCOL));
//        elementAttributeMap.put(WEB_DOMAIN, testElement.getPropertyAsString(HTTPSamplerBase.DOMAIN));
//        elementAttributeMap.put(WEB_PORT, testElement.getPropertyAsString(HTTPSamplerBase.PORT));
//        elementAttributeMap.put(WEB_CONTENT_ENCODING, testElement.getPropertyAsString(HTTPSamplerBase.CONTENT_ENCODING));
//
//        List<Map<String, Object>> arguments = new ArrayList<>();
//        Arguments vars = (Arguments) ((TestElementProperty)testElement.getProperty(HTTPSamplerBase.ARGUMENTS)).getElement();
//        PropertyIterator iterator = vars.iterator();
//        while (iterator.hasNext()){
//            Map<String, Object> argument = new HashMap<>();
//            HTTPArgument httpArgument = (HTTPArgument) ((TestElementProperty) iterator.next()).getElement();
//            argument.put("id", System.identityHashCode(httpArgument));
//            argument.put("name", httpArgument.getName());
//            argument.put("value", httpArgument.getValue());
//            argument.put("metadata", httpArgument.getMetaData());
//            argument.put("contentType", httpArgument.getContentType());
//            argument.put("useEquals", httpArgument.isUseEquals());
//            argument.put("alwaysEncode", httpArgument.isAlwaysEncoded());
//            arguments.add(argument);
//        }
//        elementAttributeMap.put(WEB_ARGUMENTS, arguments);
//
//        elementAttributeMap.put(WEB_IMPLEMENTATION, testElement.getPropertyAsString(HTTPSamplerBase.IMPLEMENTATION));
//        elementAttributeMap.put(WEB_CONNECT_TIMEOUT, testElement.getPropertyAsString(HTTPSamplerBase.CONNECT_TIMEOUT));
//        elementAttributeMap.put(WEB_RESPONSE_TIMEOUT, testElement.getPropertyAsString(HTTPSamplerBase.RESPONSE_TIMEOUT));
//        elementAttributeMap.put(WEB_IMAGE_PARSER, testElement.getPropertyAsBoolean(HTTPSamplerBase.IMAGE_PARSER));
//        elementAttributeMap.put(WEB_CONCURRENT_DWN, testElement.getPropertyAsBoolean(HTTPSamplerBase.CONCURRENT_DWN));
//        elementAttributeMap.put(WEB_CONCURRENT_POOL, testElement.getPropertyAsString(HTTPSamplerBase.CONCURRENT_POOL));
//        elementAttributeMap.put(WEB_EMBEDDED_URL_RE, testElement.getPropertyAsString(HTTPSamplerBase.EMBEDDED_URL_RE));
//        elementAttributeMap.put(WEB_IP_SOURCE_TYPE, testElement.getPropertyAsInt(HTTPSamplerBase.IP_SOURCE_TYPE));
//        elementAttributeMap.put(WEB_IP_SOURCE, testElement.getPropertyAsString(HTTPSamplerBase.IP_SOURCE));
//        elementAttributeMap.put(WEB_PROXY_SCHEME, testElement.getPropertyAsString(HTTPSamplerBase.PROXYSCHEME));
//        elementAttributeMap.put(WEB_PROXY_HOST, testElement.getPropertyAsString(HTTPSamplerBase.PROXYHOST));
//        elementAttributeMap.put(WEB_PROXY_PORT, testElement.getPropertyAsString(HTTPSamplerBase.PROXYPORT));
//        elementAttributeMap.put(WEB_PROXY_USER, testElement.getPropertyAsString(HTTPSamplerBase.PROXYUSER));
//        elementAttributeMap.put(WEB_PROXY_PASS, testElement.getPropertyAsString(HTTPSamplerBase.PROXYPASS));
//        elementAttributeMap.put(WEB_MD5, testElement.getPropertyAsBoolean(HTTPSamplerBase.MD5));
//    }
//
//
//    private void setTcpConfigMap(){
//        elementAttributeMap.put(WEB_CLASSNAME, testElement.getPropertyAsString(TCPSampler.CLASSNAME));
//        elementAttributeMap.put(WEB_SERVER, testElement.getPropertyAsString(TCPSampler.SERVER));
//        elementAttributeMap.put(WEB_TCP_PORT, testElement.getPropertyAsString(TCPSampler.PORT));
//        elementAttributeMap.put(WEB_C_TIMEOUT, testElement.getPropertyAsString(TCPSampler.TIMEOUT_CONNECT));
//        elementAttributeMap.put(WEB_TIMEOUT, testElement.getPropertyAsString(TCPSampler.TIMEOUT));
//        elementAttributeMap.put(WEB_RE_USE_CONNECTION, testElement.getPropertyAsBoolean(TCPSampler.RE_USE_CONNECTION));
//        elementAttributeMap.put(WEB_CLOSE_CONNECTION, testElement.getPropertyAsBoolean(TCPSampler.CLOSE_CONNECTION));
//        elementAttributeMap.put(WEB_NODELAY, testElement.getPropertyAsString(TCPSampler.NODELAY));
//        elementAttributeMap.put(WEB_SO_LINGER, testElement.getPropertyAsString(TCPSampler.SO_LINGER));
//        elementAttributeMap.put(WEB_REQUEST, testElement.getPropertyAsString(TCPSampler.REQUEST));
//        elementAttributeMap.put(WEB_EOL_BYTE, testElement.getPropertyAsString(TCPSampler.EOL_BYTE));
//    }
}
