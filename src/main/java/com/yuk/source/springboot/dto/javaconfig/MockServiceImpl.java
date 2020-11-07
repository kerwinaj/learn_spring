package com.yuk.source.springboot.dto.javaconfig;

public class MockServiceImpl implements MockService {
    MockDependencyService mockDependencyService;

    public MockServiceImpl(MockDependencyService mockDependencyService) {
        this.mockDependencyService = mockDependencyService;
    }

    public MockDependencyService getMockDependencyService() {
        return mockDependencyService;
    }
}
