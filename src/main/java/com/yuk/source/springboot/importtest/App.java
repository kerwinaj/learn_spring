package com.yuk.source.springboot.importtest;

import com.yuk.source.springboot.dto.Cat;
import com.yuk.source.springboot.dto.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({Dog.class, Cat.class})
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		// 不能给这个bean起个新名字的了
//		System.out.println(context.getBean("myDog", Dog.class));
		System.out.println(context.getBean(Dog.class));
		System.out.println(context.getBean(Cat.class));
		context.close();
	}
}
