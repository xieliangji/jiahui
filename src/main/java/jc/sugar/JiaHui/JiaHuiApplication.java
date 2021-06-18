package jc.sugar.JiaHui;

import jc.sugar.JiaHui.jmeter.JMeterMapperUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JiaHuiApplication {

	public static void main(String[] args) {
		System.out.println(JMeterMapperUtil.getJMeterElementMappers());
		SpringApplication.run(JiaHuiApplication.class, args);
	}

}
