package com.yuk.source.springboot.importtest5;

import com.yuk.source.springboot.SpringUtils;
import com.yuk.source.springboot.dto.Cat;
import com.yuk.source.springboot.dto.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * https://blog.csdn.net/panchao888888/article/details/82882279
 */
@SpringBootApplication
@Import(MyImportSelector.class)
public class App05 {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App05.class, args);
		SpringUtils.printBeanIgnoreException(context, "myDog", Dog.class);
		SpringUtils.printBeanIgnoreException(context, Dog.class);
		SpringUtils.printBeanIgnoreException(context, Cat.class);
		SpringUtils.printAllBean(context, new Class[]{Dog.class, Cat.class});
		context.close();
	}


}
