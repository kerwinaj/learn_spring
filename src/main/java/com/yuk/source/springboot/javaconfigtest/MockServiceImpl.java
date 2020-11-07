package com.yuk.source.springboot.javaconfigtest;

public class MockServiceImpl implements MockService {
    DependencyService dependencyService;

    public MockServiceImpl(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }
}
