package com.springtechie.crud.configs;

import com.springtechie.crud.endpoints.DummyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomeBeanCreationDemo {


    @Bean
    public DummyController dummyController() {
        System.out.println("DummyController bean is  creating");
        DummyController dummyController = new DummyController();
        return dummyController;
    }

}
