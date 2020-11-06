package com.yuk.source.springboot.importtest3;

import com.yuk.source.springboot.dto.Cat;
import com.yuk.source.springboot.dto.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 */
@SpringBootApplication
public class App03 {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App03.class, args);
		System.out.println(context.getBean("myDog", Dog.class));
		System.out.println(context.getBean(Dog.class));
		System.out.println(context.getBean(Cat.class));
		context.close();
	}
}
