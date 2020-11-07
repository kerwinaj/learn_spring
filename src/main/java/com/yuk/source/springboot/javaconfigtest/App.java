package com.yuk.source.springboot.javaconfigtest;

import com.yuk.source.springboot.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		SpringUtils.printAllBean(context, new Class[]{});
		context.close();
	}


}
