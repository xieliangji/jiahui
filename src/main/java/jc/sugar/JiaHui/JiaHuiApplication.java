package jc.sugar.JiaHui;

import jc.sugar.JiaHui.jmeter.JMeterInitializer;
import jc.sugar.JiaHui.jmeter.SugarJMeterContext;
import jc.sugar.JiaHui.utils.SugarClassLoaderUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;

@SpringBootApplication
@MapperScan(basePackages = {"jc.sugar.JiaHui.dao"})
public class JiaHuiApplication {


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		JMeterInitializer.initialize();
		SpringApplication.run(JiaHuiApplication.class, args);
	}
}
