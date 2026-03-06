package com.springtechie.crud.services;

import com.springtechie.crud.models.Employee;
import com.springtechie.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${server.port}")
    private String portNumber;

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
        System.out.println(portNumber);
        return employeeRepository.findAll(); // select * from student limit 10
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getEmployeesBySize(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "fname");
        PageRequest pageRequest = PageRequest.of(page, size,sort);
        Page<Employee> employees = employeeRepository.findAll(pageRequest);
        Stream<Employee> employeeStream = employees.get();
        List<Employee> collect = employeeStream.collect(Collectors.toList());
        return collect;

    }


}
