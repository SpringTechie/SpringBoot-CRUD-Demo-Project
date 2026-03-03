package com.springtechie.crud.services;

import com.springtechie.crud.models.Employee;
import com.springtechie.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${mysql:defaultUser}")
    private List<String> userName;

    @Value("#{T(java.lang.Math).random()}")
    private double randomValue;

    public EmployeeService() {
        System.out.println("EmployeeService bean is created");
    }

    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Account created Successfully";
    }

    public List<Employee> getAllEmployees() {
        System.out.println(randomValue);
        System.out.println(userName.size());
        return employeeRepository.findAll(); // select * from employee
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get(); // select * from employee where id = 2
    }


}
