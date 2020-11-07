package com.yuk.source.springboot.javaconfigtest;

import com.yuk.source.springboot.dto.javaconfig.MockDependencyService;
import com.yuk.source.springboot.dto.javaconfig.MockDependencyServiceImpl;
import com.yuk.source.springboot.dto.javaconfig.MockService;
import com.yuk.source.springboot.dto.javaconfig.MockServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockConfiguration {
    @Bean
    public MockService mockService(){
        return new MockServiceImpl(dependencyService());
    }

    @Bean
    public MockDependencyService dependencyService(){
        return new MockDependencyServiceImpl();
    }
}
