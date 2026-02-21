package com.springtechie.crud.services;

import com.springtechie.crud.models.Employee;
import com.springtechie.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Account created Successfully";
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // select * from employee
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get(); // select * from employee where id = 2
    }


}
