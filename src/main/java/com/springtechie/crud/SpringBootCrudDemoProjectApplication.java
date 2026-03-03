package com.springtechie.crud;

import com.springtechie.crud.services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCrudDemoProjectApplication {

	public static void main(String[] args) {
	ApplicationContext context =  SpringApplication.run(SpringBootCrudDemoProjectApplication.class, args); // factory
		EmployeeService bean = context.getBean(EmployeeService.class);


	}

}

