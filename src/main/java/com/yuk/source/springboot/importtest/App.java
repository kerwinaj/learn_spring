package com.yuk.source.springboot.importtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({Dog.class, Cat.class})
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println(context.getBean(Dog.class));
		System.out.println(context.getBean(Cat.class));
		context.close();
	}
}
