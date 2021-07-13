package jc.sugar.JiaHui;

import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = {"jc.sugar.JiaHui.dao"})
public class JiaHuiApplication {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		JMeterInitializer.initialize();
		SpringApplication.run(JiaHuiApplication.class, args);
	}
}
