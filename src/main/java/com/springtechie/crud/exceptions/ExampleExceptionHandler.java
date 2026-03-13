package com.springtechie.crud.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExampleExceptionHandler {


    @ExceptionHandler(exception = {RuntimeException.class})
    public String handleException(RuntimeException ex) {
        System.out.println("Exception is occured RuntimeException");
        return ex.getMessage();
    }

    @ExceptionHandler(exception = {NoSuchElementException.class})
    public String handleException(NoSuchElementException ex) {
        System.out.println("Exception is occured NoSuchElementException");
        return ex.getMessage();
    }



}
