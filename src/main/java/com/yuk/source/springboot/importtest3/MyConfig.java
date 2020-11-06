package com.yuk.source.springboot.importtest3;

import com.yuk.source.springboot.dto.Cat;
import com.yuk.source.springboot.dto.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(name="myDog")
    public Dog getDog(){
        return new Dog();
    }

    @Bean(name="myCat")
    public Cat getCat(){
        return new Cat();
    }

}
