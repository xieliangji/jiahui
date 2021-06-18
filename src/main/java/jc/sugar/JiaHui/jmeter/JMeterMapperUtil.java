package jc.sugar.JiaHui.jmeter;

import jc.sugar.JiaHui.jmeter.exceptions.JMeterTestElementMapperException;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.apache.jorphan.util.Converter.getString;

public class JMeterMapperUtil {
    private static final Map<String, Class<? extends JMeterElementMapper>> JMETER_ELEMENT_MAPPERS = new HashMap<>();

    static {
        Reflections reflections= new Reflections("jc.sugar.JiaHui.jmeter");
        Set<Class<? extends JMeterElementMapper>> mapperClasses = reflections.getSubTypesOf(JMeterElementMapper.class);

        for(Class<? extends JMeterElementMapper> mapperClass: mapperClasses){
            JMeterElementMapperFor annotation = mapperClass.getDeclaredAnnotation(JMeterElementMapperFor.class);
            if(annotation != null){
                JMETER_ELEMENT_MAPPERS.put(annotation.value(), mapperClass);
            }
        }
    }

    public static TestElement buildJMeterElement(Map<String, Object> attributes) throws JMeterTestElementMapperException {
        String elementType = getString(attributes.get(JMeterElementMapperRoot.WEB_TYPE));
        Class<? extends JMeterElementMapper> mapperClass = JMETER_ELEMENT_MAPPERS.get(elementType);
        if(mapperClass == null){
            throw new JMeterTestElementMapperException("Not Found Element Mapper for Type [" + elementType + "]");
        }
        try {
            return mapperClass.getConstructor(Map.class).newInstance(attributes).fromAttributes();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new JMeterTestElementMapperException(e);
        }
    }

    public static Map<String, Class<? extends JMeterElementMapper>> getJMeterElementMappers(){
        return JMETER_ELEMENT_MAPPERS;
    }

    public static void main(String[] args) throws JMeterTestElementMapperException {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("type", JMeterElementType.TestPlan);
        attributes.put("arguments", new ArrayList<>());
        TestPlan testPlan = (TestPlan) buildJMeterElement(attributes);
        System.out.println(testPlan);
    }

}
