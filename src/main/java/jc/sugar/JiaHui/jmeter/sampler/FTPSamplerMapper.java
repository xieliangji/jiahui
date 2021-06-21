package jc.sugar.JiaHui.jmeter.sampler;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.protocol.ftp.sampler.FTPSampler;
import org.apache.jmeter.testelement.TestElement;

import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.FTPSampler, testGuiClass = JMeterElement.FTPSampler)
public class FTPSamplerMapper extends JMeterElementMapperRoot<FTPSampler> {
    public static final String WEB_SERVER = "server";

    public static final String WEB_PORT = "port";

    public static final String WEB_FILENAME = "filename";

    public static final String WEB_LOCAL_FILENAME = "localFilename";

    public static final String WEB_INPUT_DATA = "inputData";

    public static final String WEB_BINARY_MODE = "binaryMode";

    public static final String WEB_SAVE_RESPONSE = "saveResponse";

    public static final String WEB_UPLOAD = "upload";

    public static final String WEB_USERNAME = "username";

    public static final String WEB_PASSWORD = "password";

    private FTPSamplerMapper(FTPSampler element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    @Override
    public FTPSampler fromAttributes() {
        setFTPElement(element, attributes);

        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Sampler);
        attributes.put(WEB_TYPE, JMeterElementType.FTPSampler);
        setFTPAttributes(attributes, element);
        return attributes;
    }

    public static <T extends TestElement> void setFTPElement(T element, Map<String, Object> attributes){
        element.setProperty(FTPSampler.SERVER, getString(attributes.get(WEB_SERVER)));
        element.setProperty(FTPSampler.PORT, getString(attributes.get(WEB_PORT)));
        element.setProperty(FTPSampler.REMOTE_FILENAME, getString(attributes.get(WEB_FILENAME)));
        element.setProperty(FTPSampler.LOCAL_FILENAME, getString(attributes.get(WEB_LOCAL_FILENAME)));
        element.setProperty(FTPSampler.INPUT_DATA, getString(attributes.get(WEB_INPUT_DATA)));
        element.setProperty(FTPSampler.BINARY_MODE, getBoolean(attributes.get(WEB_BINARY_MODE)));
        element.setProperty(FTPSampler.SAVE_RESPONSE, getBoolean(attributes.get(WEB_SAVE_RESPONSE)));
        element.setProperty(FTPSampler.UPLOAD_FILE, getBoolean(attributes.get(WEB_UPLOAD)));
        if(element instanceof FTPSampler){
            element.setProperty(ConfigTestElement.USERNAME, getString(attributes.get(WEB_USERNAME)));
            element.setProperty(ConfigTestElement.PASSWORD, getString(attributes.get(WEB_PASSWORD)));
        }
    }

    public static <T extends TestElement> void setFTPAttributes(Map<String, Object> attributes, T element){
        attributes.put(WEB_SERVER, element.getPropertyAsString(FTPSampler.SERVER));
        attributes.put(WEB_PORT, element.getPropertyAsString(FTPSampler.PORT));
        attributes.put(WEB_FILENAME, element.getPropertyAsString(FTPSampler.REMOTE_FILENAME));
        attributes.put(WEB_LOCAL_FILENAME, element.getPropertyAsString(FTPSampler.LOCAL_FILENAME));
        attributes.put(WEB_INPUT_DATA, element.getPropertyAsString(FTPSampler.INPUT_DATA));
        attributes.put(WEB_BINARY_MODE, element.getPropertyAsBoolean(FTPSampler.BINARY_MODE));
        attributes.put(WEB_SAVE_RESPONSE, element.getPropertyAsBoolean(FTPSampler.SAVE_RESPONSE));
        attributes.put(WEB_UPLOAD, element.getPropertyAsBoolean(FTPSampler.UPLOAD_FILE));
        if(element instanceof FTPSampler){
            attributes.put(WEB_USERNAME, element.getPropertyAsString(ConfigTestElement.USERNAME));
            attributes.put(WEB_PASSWORD, element.getPropertyAsString(ConfigTestElement.PASSWORD));
        }
    }
}
