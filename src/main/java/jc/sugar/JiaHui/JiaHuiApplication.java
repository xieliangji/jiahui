package jc.sugar.JiaHui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"jc.sugar.JiaHui.dao"})
public class JiaHuiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiaHuiApplication.class, args);
	}

}
