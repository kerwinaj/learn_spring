package com.yuk.source.springboot.importtest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * https://blog.csdn.net/pange1991/article/details/81356594
 */
@SpringBootApplication
@Import(MyConfig.class)
public class App02 {
	/**
	 * 报下面这个错是因为: App02和App放在同一个目录下了, 笑哭!!
	 * Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.yuk.source.springboot.importtest.Dog' available: expected single matching bean but found 2: com.yuk.source.springboot.importtest.Dog,getDog
	 * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(DefaultListableBeanFactory.java:1039)
	 * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:339)
	 * 	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:334)
	 * 	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1107)
	 * 	at com.yuk.source.springboot.importtest.App02.main(App02.java:17)
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App02.class, args);
		System.out.println(context.getBean("myDog", Dog.class));
		System.out.println(context.getBean(Dog.class));
		System.out.println(context.getBean(Cat.class));
		context.close();
	}
}
