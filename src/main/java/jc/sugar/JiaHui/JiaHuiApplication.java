package jc.sugar.JiaHui;

import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = {"jc.sugar.JiaHui.dao"})
public class JiaHuiApplication {
	public static void main(String[] args) {
		JMeterInitializer.initialize();
		SpringApplication.run(JiaHuiApplication.class, args);
	}
}
