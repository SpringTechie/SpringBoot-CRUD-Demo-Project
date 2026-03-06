package com.springtechie.crud.configs;

import com.springtechie.crud.endpoints.DummyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","stage"})
public class CustomeBeanCreationDemo {


    @Bean
    @Profile({"dev","stage"})
    public DummyController dummyController() {
        System.out.println("DummyController bean is  creating");
        DummyController dummyController = new DummyController();
        return dummyController;
    }

}
