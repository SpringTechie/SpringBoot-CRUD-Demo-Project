package com.springtechie.crud.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class SchduelingExample {

    @Scheduled(fixedDelay = 3000)
    public void exampleJob() {
        System.out.println("Hello Raja");
    }
}
