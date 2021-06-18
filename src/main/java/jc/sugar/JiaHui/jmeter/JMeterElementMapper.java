package jc.sugar.JiaHui.jmeter;

import org.apache.jmeter.testelement.TestElement;

import java.util.Map;

public interface JMeterElementMapper<T extends TestElement> {

    T fromAttributes();


    Map<String, Object> toAttributes();
}
