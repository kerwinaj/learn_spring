package com.yuk.source.springboot.javaconfigtest02;

import com.yuk.source.springboot.dto.javaconfig.MockDependencyService;
import com.yuk.source.springboot.dto.javaconfig.MockDependencyServiceImpl;
import com.yuk.source.springboot.dto.javaconfig.MockService;
import com.yuk.source.springboot.dto.javaconfig.MockServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockConfiguration02 {
    @Bean
    public MockService mockService(){
        return new MockServiceImpl(dependencyService());
    }

    public MockDependencyService dependencyService(){
        return new MockDependencyServiceImpl();
    }
}
