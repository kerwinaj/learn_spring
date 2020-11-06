package com.yuk.source.springboot.importtest2;

import com.yuk.source.springboot.dto.Cat;
import com.yuk.source.springboot.dto.Dog;
import org.springframework.context.annotation.Bean;

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
