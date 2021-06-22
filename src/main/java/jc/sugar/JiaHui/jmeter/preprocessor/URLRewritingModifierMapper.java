package jc.sugar.JiaHui.jmeter.preprocessor;

import jc.sugar.JiaHui.jmeter.*;
import org.apache.jmeter.protocol.http.modifier.URLRewritingModifier;

import java.util.HashMap;
import java.util.Map;

import static org.apache.jorphan.util.Converter.getBoolean;
import static org.apache.jorphan.util.Converter.getString;

@JMeterElementMapperFor(value = JMeterElementType.URLRewritingModifier, testGuiClass = JMeterElement.URLRewritingModifier)
public class URLRewritingModifierMapper extends AbstractJMeterElementMapper<URLRewritingModifier> {

    public static final String WEB_ARGUMENT_NAME = "argumentName";

    public static final String WEB_PATH_EXTENSION = "pathExtension";

    public static final String WEB_PATH_EXTENSION_NO_EQUAL = "pathExtensionNoEqual";

    public static final String WEB_PATH_EXTENSION_NO_QUESTION_MARK = "pathExtensionNoQuestionMark";

    public static final String WEB_CACHE_VALUE = "cacheValue";

    public static final String WEB_ENCODE = "encode";

    private URLRewritingModifierMapper(URLRewritingModifier element, Map<String, Object> attributes) {
        super(element, attributes);
    }

    public URLRewritingModifierMapper(Map<String, Object> attributes){
        this(new URLRewritingModifier(), attributes);
    }

    public URLRewritingModifierMapper(URLRewritingModifier element){
        this(element, new HashMap<>());
    }

    @Override
    public URLRewritingModifier fromAttributes() {
        element.setArgumentName(getString(attributes.get(WEB_ARGUMENT_NAME)));
        element.setPathExtension(getBoolean(attributes.get(WEB_PATH_EXTENSION)));
        element.setPathExtensionNoEquals(getBoolean(attributes.get(WEB_PATH_EXTENSION_NO_EQUAL)));
        element.setPathExtensionNoQuestionmark(getBoolean(attributes.get(WEB_PATH_EXTENSION_NO_QUESTION_MARK)));
        element.setShouldCache(getBoolean(attributes.get(WEB_CACHE_VALUE)));
        element.setEncode(getBoolean(WEB_ENCODE));
        return element;
    }

    @Override
    public Map<String, Object> toAttributes() {
        attributes.put(WEB_CATEGORY, JMeterElementCategory.Preprocessor);
        attributes.put(WEB_TYPE, JMeterElementType.URLRewritingModifier);

        attributes.put(WEB_CATEGORY, element.getArgumentName());
        attributes.put(WEB_PATH_EXTENSION, element.isPathExtension());
        attributes.put(WEB_PATH_EXTENSION_NO_EQUAL, element.isPathExtensionNoEquals());
        attributes.put(WEB_PATH_EXTENSION_NO_QUESTION_MARK, element.isPathExtensionNoQuestionmark());
        attributes.put(WEB_CACHE_VALUE, element.shouldCache());
        attributes.put(WEB_ENCODE, element.encode());

        return attributes;
    }
}
