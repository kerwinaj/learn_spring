package com.yuk.source.springboot.importtest4;

import com.yuk.source.springboot.SpringUtils;
import com.yuk.source.springboot.dto.Cat;
import com.yuk.source.springboot.dto.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 */
@SpringBootApplication
public class App04 {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App04.class, args);
		System.out.println(context.getBean("myDog", Dog.class));
		System.out.println(context.getBean(Dog.class));
		System.out.println(context.getBean(Cat.class));
		SpringUtils.printAllBean(context, new Class[]{Dog.class, Cat.class});
		context.close();
	}
}
