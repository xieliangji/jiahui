package jc.sugar.JiaHui.jmeter;

import jc.sugar.JiaHui.jmeter.exceptions.JMeterTestElementMapperException;
import org.apache.jmeter.control.gui.TestPlanGui;
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
    private static final Map<JMeterElementMapperFor, Class<? extends JMeterElementMapper>> JMeterElementMappers = new HashMap<>();

    static {
        Reflections reflections= new Reflections("jc.sugar.JiaHui.jmeter");
        Set<Class<? extends JMeterElementMapper>> mapperClasses = reflections.getSubTypesOf(JMeterElementMapper.class);

        for(Class<? extends JMeterElementMapper> mapperClass: mapperClasses){
            JMeterElementMapperFor annotation = mapperClass.getDeclaredAnnotation(JMeterElementMapperFor.class);
            if(annotation != null){
                JMeterElementMappers.put(annotation, mapperClass);
            }
        }
    }

    /**
     * 从前端属性map中生成JMeter TestElement对象
     * @param attributes
     * @return
     * @throws JMeterTestElementMapperException
     */
    public static TestElement buildJMeterElement(Map<String, Object> attributes) throws JMeterTestElementMapperException {
        String elementType = getString(attributes.get(AbstractJMeterElementMapper.WEB_TYPE));
        Class<? extends JMeterElementMapper> mapperClass = null;
        for(JMeterElementMapperFor key: JMeterElementMappers.keySet()){
            if(key.value().equals(elementType)){
                mapperClass = JMeterElementMappers.get(key);
            }
        }

        if(mapperClass == null){
            throw new JMeterTestElementMapperException("Not Found Element Mapper for Type [" + elementType + "]");
        }
        try {
            return mapperClass.getConstructor(Map.class).newInstance(attributes).fromAttributes();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            throw new JMeterTestElementMapperException(e);
        }
    }

    /**
     * 从TestElement对象生成前端属性map
     * @param element
     * @return
     * @throws JMeterTestElementMapperException
     */
    public static Map<String, Object> buildJMeterElementAttributes(TestElement element) throws JMeterTestElementMapperException {
        String guiClass = element.getPropertyAsString(TestElement.GUI_CLASS);
        String testClass = element.getClass().getSimpleName();

        Class<? extends JMeterElementMapper> mapperClass = null;
        for(JMeterElementMapperFor key: JMeterElementMappers.keySet()){
            JMeterElement jMeterElement = key.testGuiClass();
            if(testClass.equals(jMeterElement.getTestClass()) && guiClass.equals(jMeterElement.getGuiClass())){
                mapperClass = JMeterElementMappers.get(key);
            }
        }

        if(mapperClass == null){
            throw new JMeterTestElementMapperException("Not Found Element Mapper for TestElement [" + element.getClass().getName() + "]");
        }

        try {
            return mapperClass.getConstructor(element.getClass()).newInstance(element).toAttributes();
        } catch (InvocationTargetException | InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
            throw new JMeterTestElementMapperException(e);
        }
    }


    public static void main(String[] args) throws JMeterTestElementMapperException {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("type", JMeterElementType.TestPlan);
        attributes.put("guiclass", TestPlanGui.class.getSimpleName());
        attributes.put("testclass", TestPlan.class.getSimpleName());
        attributes.put("arguments", new ArrayList<>());
        TestPlan testPlan = (TestPlan) buildJMeterElement(attributes);
        System.out.println(testPlan.getProperty(TestElement.GUI_CLASS) + " >>>>" + testPlan.getProperty(TestElement.TEST_CLASS));
        System.out.println(testPlan.getTestPlanClasspath());
        Map<String, Object> attributes2 = buildJMeterElementAttributes(testPlan);
        System.out.println(attributes2);
    }

}
