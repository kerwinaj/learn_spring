package com.yuk.source.springboot.javaconfigtest;

public class MockServiceImpl implements MockService {
    MockDependencyService mockDependencyService;

    public MockServiceImpl(MockDependencyService mockDependencyService) {
        this.mockDependencyService = mockDependencyService;
    }

    public MockDependencyService getMockDependencyService() {
        return mockDependencyService;
    }
}
