package com.yuk.spring.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController2 {

    /**
     * This code uses Spring 4’s new @RestController annotation, which marks the class as a controller where every method returns a domain object instead of a view. It’s shorthand for @Controller and @ResponseBody rolled together.
     * @return
     */
    @RequestMapping("/hello21")
    public String hello(){
        return "hello world from [HelloController2]";
    }

    @RequestMapping("/hello22")
    @ResponseBody
    public String hello2(){
        return "hello world from [HelloController2]";
    }
}
