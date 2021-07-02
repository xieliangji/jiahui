package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import jc.sugar.JiaHui.jmeter.configtestelement.ArgumentsMapper;
import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.http.util.HTTPArgument;
import org.apache.jmeter.protocol.http.util.HTTPFileArg;
import org.apache.jmeter.protocol.http.util.HTTPFileArgs;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.PropertyIterator;
import org.apache.jmeter.testelement.property.TestElementProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.jorphan.util.Converter.*;

@JMeterElementMapperFor(value = JMeterElementType.HttpTestSample, testGuiClass = JMeterElement.HttpTestSample)
public class HttpSamplerMapper extends AbstractJMeterElementMapper<HTTPSamplerProxy> {

    /**
     * +JMX key names
     */
    private static final String FILE_ARGS = "HTTPsampler.Files";

    private static final String FILEPATH = "File.path";

    /** Name used to store the file's paramname. */
    private static final String PARAMNAME = "File.paramname";

    /** Name used to store the file's mimetype. */
    private static final String MIMETYPE = "File.mimetype";

    /**
     * +Web key names - do not change.
     */
    public static final String WEB_PROTOCOL = "protocol";

    public static final String WEB_DOMAIN = "domain";

    public static final String WEB_PORT = "port";

    public static final String WEB_METHOD = "method";

    public static final String WEB_PATH = "path";

    public static final String WEB_CONTENT_ENCODING = "contentEncoding";

    public static final String WEB_FOLLOW_REDIRECTS = "followRedirects";

    public static final String WEB_AUTO_REDIRECTS = "autoRedirects";

    public static final String WEB_USE_KEEP_ALIVE = "useKeepAlive";

    public static final String WEB_DO_MULTIPART = "doMultipartPost";

    public static final String WEB_BROWSER_COMPATIBLE = "browserCompatibleMultipart";

    public static final String WEB_POST_BODY_RAW = "postBodyRaw";

    public static final String WEB_ARGUMENTS = "arguments";

    public static final String WEB_FILES = "files";

    public static final String WEB_IMPLEMENTATION = "implementation";

    public static final String WEB_CONNECT_TIMEOUT = "connectTimeout";

    public static final String WEB_RESPONSE_TIMEOUT = "responseTimeout";

    public static final String WEB_IMAGE_PARSER = "imageParser";

    public static final String WEB_CONCURRENT_DWN = "concurrentDwn";

    public static final String WEB_CONCURRENT_POOL = "concurrentPool";

    public static final String WEB_URL_MUST_MATCH = "embeddedUrlRe";

    public static final String WEB_URL_MUST_NOT_MATCH = "embeddedUrlExcludeRe";

    public static final String WEB_IP_SOURCE_TYPE = "ipSourceType";

    public static final String WEB_IP_SOURCE = "ipSource";

    public static final String WEB_PROXY_SCHEME = "proxyScheme";

    public static final String WEB_PROXY_HOST = "proxyHost";

    public static final String WEB_PROXY_PORT = "proxyPort";

    public static final String WEB_PROXY_USER = "proxyUser";

    public static final String WEB_PROXY_PASS = "proxyPass";

    public static final String WEB_MD5 = "md5";


    private HttpSamplerMapper(HTTPSamplerProxy element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public HttpSamplerMapper(Map<String, Object> attributes){
        this(new HTTPSamplerProxy(), attributes);
    }

    public HttpSamplerMapper(HTTPSamplerProxy element){
        super(element, new HashMap<>());
    }

    @Override
    public HTTPSamplerProxy fromAttributes() {
        setElement(element, attributes);
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.HttpTestSample);
        setAttributes(element, attributes);
        return attributes;
    }

    public static <T extends TestElement> void setElement(T element, Map<String, Object> attributes){
        element.setProperty(HTTPSamplerBase.PROTOCOL, getString(attributes.get(WEB_PROTOCOL)));
        element.setProperty(HTTPSamplerBase.DOMAIN, getString(attributes.get(WEB_DOMAIN)));
        element.setProperty(HTTPSamplerBase.PORT, getString(attributes.get(WEB_PORT)));
        element.setProperty(HTTPSamplerBase.METHOD, getString(attributes.get(WEB_METHOD)));
        element.setProperty(HTTPSamplerBase.PATH, getString(attributes.get(WEB_PATH)));
        element.setProperty(HTTPSamplerBase.CONTENT_ENCODING, getString(attributes.get(WEB_CONTENT_ENCODING)));

        element.setProperty(HTTPSamplerBase.FOLLOW_REDIRECTS, getBoolean(attributes.get(WEB_FOLLOW_REDIRECTS)));
        element.setProperty(HTTPSamplerBase.AUTO_REDIRECTS, getBoolean(attributes.get(WEB_AUTO_REDIRECTS)));
        element.setProperty(HTTPSamplerBase.USE_KEEPALIVE, getBoolean(attributes.get(WEB_USE_KEEP_ALIVE)));
        element.setProperty(HTTPSamplerBase.DO_MULTIPART_POST, getBoolean(attributes.get(WEB_DO_MULTIPART)));
        element.setProperty(HTTPSamplerBase.BROWSER_COMPATIBLE_MULTIPART, getBoolean(attributes.get(WEB_BROWSER_COMPATIBLE)));

        element.setProperty(HTTPSamplerBase.POST_BODY_RAW, getBoolean(attributes.get(WEB_POST_BODY_RAW)));
        List<Map<String, Object>> argumentAttributesList = (List<Map<String, Object>>) attributes.get(WEB_ARGUMENTS);
        Arguments arguments = new Arguments();
        element.setProperty(new TestElementProperty(HTTPSamplerBase.ARGUMENTS, arguments));
        if(getBoolean(attributes.get(WEB_POST_BODY_RAW))){
            if(argumentAttributesList.size() > 0){
                Map<String, Object> argumentAttributes =  argumentAttributesList.get(0);
                HTTPArgument argument = new HTTPArgument(
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENT_NAME)),
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENT_VALUE)),
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENT_METADATA)),
                        getBoolean(argumentAttributes.get(ArgumentsMapper.WEB_ALWAYS_ENCODE)),
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_CONTENT_TYPE))
                );
                arguments.addArgument(argument);
            }
        } else {
            for(Map<String, Object> argumentAttributes: argumentAttributesList){
                HTTPArgument argument = new HTTPArgument(
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENT_NAME)),
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENT_VALUE)),
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_ARGUMENT_METADATA)),
                        getBoolean(argumentAttributes.get(ArgumentsMapper.WEB_ALWAYS_ENCODE)),
                        getString(argumentAttributes.get(ArgumentsMapper.WEB_CONTENT_TYPE))
                );
                argument.setUseEquals(getBoolean(argumentAttributes.get(ArgumentsMapper.WEB_USE_EQUALS)));
                arguments.addArgument(argument);
            }
        }

        // 文件上传
        List<Map<String, Object>> fileAttributesList = (List<Map<String, Object>>) attributes.get(WEB_FILES);
        if(fileAttributesList != null){
            HTTPFileArgs httpFileArgs = new HTTPFileArgs();
            element.setProperty(new TestElementProperty(FILE_ARGS, httpFileArgs));
            for (Map<String, Object> fileAttributes: fileAttributesList){
                HTTPFileArg httpFileArg = new HTTPFileArg(
                        getString(fileAttributes.get(ArgumentsMapper.WEB_FILE_PATH)),
                        getString(fileAttributes.get(ArgumentsMapper.WEB_FILE_PARAMNAME)),
                        getString(fileAttributes.get(ArgumentsMapper.WEB_FILE_MIMETYPE))
                );
                httpFileArgs.addHTTPFileArg(httpFileArg);
            }
        }

        // 高级属性
        element.setProperty(HTTPSamplerBase.IMPLEMENTATION, getString(attributes.get(WEB_IMPLEMENTATION)));
        element.setProperty(HTTPSamplerBase.CONNECT_TIMEOUT, getString(attributes.get(WEB_CONNECT_TIMEOUT)));
        element.setProperty(HTTPSamplerBase.RESPONSE_TIMEOUT, getString(attributes.get(WEB_RESPONSE_TIMEOUT)));
        element.setProperty(HTTPSamplerBase.IMAGE_PARSER, getBoolean(attributes.get(WEB_IMAGE_PARSER)));
        element.setProperty(HTTPSamplerBase.CONCURRENT_DWN, getBoolean(attributes.get(WEB_CONCURRENT_DWN)));
        element.setProperty(HTTPSamplerBase.CONCURRENT_POOL, getString(attributes.get(WEB_CONCURRENT_POOL)));
        element.setProperty(HTTPSamplerBase.EMBEDDED_URL_RE, getString(attributes.get(WEB_URL_MUST_MATCH)));
        element.setProperty(HTTPSamplerBase.EMBEDDED_URL_EXCLUDE_RE, getString(attributes.get(WEB_URL_MUST_NOT_MATCH)));
        element.setProperty(HTTPSamplerBase.IP_SOURCE_TYPE, getInt(attributes.get(WEB_IP_SOURCE_TYPE)));
        element.setProperty(HTTPSamplerBase.IP_SOURCE, getString(attributes.get(WEB_IP_SOURCE)));
        element.setProperty(HTTPSamplerBase.PROXYSCHEME, getString(attributes.get(WEB_PROXY_SCHEME)));
        element.setProperty(HTTPSamplerBase.PROXYHOST, getString(attributes.get(WEB_PROXY_HOST)));
        element.setProperty(HTTPSamplerBase.PROXYPORT, getString(attributes.get(WEB_PROXY_PORT)));
        element.setProperty(HTTPSamplerBase.PROXYUSER, getString(attributes.get(WEB_PROXY_USER)));
        element.setProperty(HTTPSamplerBase.PROXYPASS, getString(attributes.get(WEB_PROXY_PASS)));
        element.setProperty(HTTPSamplerBase.MD5, getBoolean(attributes.get(WEB_MD5)));
    }

    public static <T extends TestElement> void setAttributes(T element, Map<String, Object> attributes){
        attributes.put(WEB_PROTOCOL, element.getPropertyAsString(HTTPSamplerBase.PROTOCOL));
        attributes.put(WEB_DOMAIN, element.getPropertyAsString(HTTPSamplerBase.DOMAIN));
        attributes.put(WEB_PORT, element.getPropertyAsString(HTTPSamplerBase.PORT));
        attributes.put(WEB_METHOD, element.getPropertyAsString(HTTPSamplerBase.METHOD));
        attributes.put(WEB_PATH, element.getPropertyAsString(HTTPSamplerBase.PATH));
        attributes.put(WEB_CONTENT_ENCODING, element.getPropertyAsString(HTTPSamplerBase.CONTENT_ENCODING));

        attributes.put(WEB_FOLLOW_REDIRECTS, element.getPropertyAsBoolean(HTTPSamplerBase.FOLLOW_REDIRECTS));
        attributes.put(WEB_AUTO_REDIRECTS, element.getPropertyAsBoolean(HTTPSamplerBase.AUTO_REDIRECTS));
        attributes.put(WEB_USE_KEEP_ALIVE, element.getPropertyAsBoolean(HTTPSamplerBase.USE_KEEPALIVE));
        attributes.put(WEB_DO_MULTIPART, element.getPropertyAsBoolean(HTTPSamplerBase.DO_MULTIPART_POST));
        attributes.put(WEB_BROWSER_COMPATIBLE, element.getPropertyAsBoolean(HTTPSamplerBase.BROWSER_COMPATIBLE_MULTIPART));

        attributes.put(WEB_POST_BODY_RAW, element.getPropertyAsBoolean(HTTPSamplerBase.POST_BODY_RAW));
        Arguments arguments = (Arguments) element.getProperty(HTTPSamplerBase.ARGUMENTS).getObjectValue();
        PropertyIterator iterator = arguments.iterator();
        List<Map<String, Object>> argumentAttributesList = new ArrayList<>();
        while(iterator.hasNext()){
            HTTPArgument argument = (HTTPArgument) iterator.next().getObjectValue();
            Map<String, Object> argumentAttributes = new HashMap<>();
            argumentAttributes.put(WEB_ID, System.identityHashCode(argument));
            argumentAttributes.put(ArgumentsMapper.WEB_ARGUMENT_NAME, argument.getPropertyAsString(Argument.ARG_NAME));
            argumentAttributes.put(ArgumentsMapper.WEB_ARGUMENT_VALUE, argument.getPropertyAsString(Argument.VALUE));
            argumentAttributes.put(ArgumentsMapper.WEB_ARGUMENT_METADATA, argument.getPropertyAsString(Argument.METADATA));
            argumentAttributes.put(ArgumentsMapper.WEB_USE_EQUALS, argument.isUseEquals());
            argumentAttributes.put(ArgumentsMapper.WEB_ALWAYS_ENCODE, argument.isAlwaysEncoded());
            argumentAttributesList.add(argumentAttributes);
        }
        attributes.put(WEB_ARGUMENTS, argumentAttributesList);

        List<Map<String, Object>> fileAttributesList = new ArrayList<>();
        HTTPFileArgs httpFileArgs = (HTTPFileArgs) element.getProperty(FILE_ARGS).getObjectValue();
        if(httpFileArgs != null){
            PropertyIterator fileIter = httpFileArgs.iterator();
            while(fileIter.hasNext()){
                HTTPFileArg httpFileArg = (HTTPFileArg) fileIter.next().getObjectValue();
                Map<String, Object> fileAttributes = new HashMap<>();
                fileAttributes.put(WEB_ID, System.identityHashCode(httpFileArg));
                fileAttributes.put(ArgumentsMapper.WEB_FILE_PATH, httpFileArg.getPropertyAsString(FILEPATH));
                fileAttributes.put(ArgumentsMapper.WEB_FILE_PARAMNAME, httpFileArg.getPropertyAsString(PARAMNAME));
                fileAttributes.put(ArgumentsMapper.WEB_FILE_MIMETYPE, httpFileArg.getPropertyAsString(MIMETYPE));
                fileAttributesList.add(fileAttributes);
            }
            attributes.put(WEB_FILES, fileAttributesList);
        }

        attributes.put(WEB_IMPLEMENTATION, element.getPropertyAsString(HTTPSamplerBase.IMPLEMENTATION));
        attributes.put(WEB_CONNECT_TIMEOUT, element.getPropertyAsString(HTTPSamplerBase.CONNECT_TIMEOUT));
        attributes.put(WEB_RESPONSE_TIMEOUT, element.getPropertyAsString(HTTPSamplerBase.RESPONSE_TIMEOUT));
        attributes.put(WEB_IMAGE_PARSER, element.getPropertyAsBoolean(HTTPSamplerBase.IMAGE_PARSER));
        attributes.put(WEB_CONCURRENT_DWN, element.getPropertyAsBoolean(HTTPSamplerBase.CONCURRENT_DWN));
        attributes.put(WEB_CONCURRENT_POOL, element.getPropertyAsString(HTTPSamplerBase.CONCURRENT_POOL));
        attributes.put(WEB_URL_MUST_MATCH, element.getPropertyAsString(HTTPSamplerBase.EMBEDDED_URL_RE));
        attributes.put(WEB_URL_MUST_NOT_MATCH, element.getPropertyAsString(HTTPSamplerBase.EMBEDDED_URL_EXCLUDE_RE));
        attributes.put(WEB_IP_SOURCE_TYPE, element.getPropertyAsInt(HTTPSamplerBase.IP_SOURCE_TYPE));
        attributes.put(WEB_IP_SOURCE, element.getPropertyAsString(HTTPSamplerBase.IP_SOURCE));
        attributes.put(WEB_PROXY_SCHEME, element.getPropertyAsString(HTTPSamplerBase.PROXYSCHEME));
        attributes.put(WEB_PROXY_HOST, element.getPropertyAsString(HTTPSamplerBase.PROXYHOST));
        attributes.put(WEB_PROXY_PORT, element.getPropertyAsString(HTTPSamplerBase.PROXYPORT));
        attributes.put(WEB_PROXY_USER, element.getPropertyAsString(HTTPSamplerBase.PROXYUSER));
        attributes.put(WEB_PROXY_PASS, element.getPropertyAsString(HTTPSamplerBase.PROXYPASS));
        attributes.put(WEB_MD5, element.getPropertyAsBoolean(HTTPSamplerBase.MD5));
    }
}
