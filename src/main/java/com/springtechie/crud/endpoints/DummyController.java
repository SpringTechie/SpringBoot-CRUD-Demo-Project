package com.springtechie.crud.endpoints;


import com.springtechie.crud.jobs.BackgroundJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @Autowired
    private BackgroundJob job;

    public DummyController() {
        System.out.println("DummyController is constructor");
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("test is called");
        job.test();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Hello Raghu");
        return "work is complted";
    }



}
