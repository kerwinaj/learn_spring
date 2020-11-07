package com.yuk.source.springboot.javaconfigtest;

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
