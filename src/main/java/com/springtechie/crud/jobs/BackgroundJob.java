package com.springtechie.crud.jobs;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BackgroundJob {


    @Async
    public void test() {
        System.out.println("BackgorundJob"+Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {

            System.out.println("Hello"+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
