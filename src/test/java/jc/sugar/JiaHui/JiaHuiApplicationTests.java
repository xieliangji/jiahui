package jc.sugar.JiaHui;

import jc.sugar.JiaHui.jmeter.JMeterElementMapper;
import org.reflections.Reflections;

import java.util.Set;

class JiaHuiApplicationTests {
    public static void main(String[] args) {
        Reflections reflections= new Reflections("jc.sugar.JiaHui.jmeter");
        Set<Class<? extends JMeterElementMapper>> sets = reflections.getSubTypesOf(JMeterElementMapper.class);
        for(Class<? extends JMeterElementMapper> e: sets){
            System.out.println(e.getName());
        }

        for(Class<? extends JMeterElementMapper> e: sets){
            System.out.println(e.getSimpleName() + ": " + "\"" + e.getSimpleName() + "\",");
        }
    }

}
