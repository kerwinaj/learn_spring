package com.yuk.source.springboot.javaconfigtest;

import com.yuk.source.springboot.SpringUtils;
import com.yuk.source.springboot.dto.javaconfig.MockDependencyService;
import com.yuk.source.springboot.dto.javaconfig.MockService;
import com.yuk.source.springboot.dto.javaconfig.MockServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		SpringUtils.printAllBean(context, new Class[]{});
		MockService mockService = context.getBean(MockService.class);
		// 是否有这个对象
		if (mockService instanceof MockServiceImpl) {
			System.out.println("yi lai:"+((MockServiceImpl) mockService).getMockDependencyService());
		}
		// 是否被spring管理(当作bean)
		SpringUtils.printBeanIgnoreException(context, MockDependencyService.class);
		context.close();
	}


}
