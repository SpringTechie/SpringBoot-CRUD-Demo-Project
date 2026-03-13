package com.springtechie.crud.endpoints;

import com.springtechie.crud.models.Employee;
import com.springtechie.crud.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired // field level injection
    private EmployeeService employeeService;

    @Autowired // constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired // setter injection
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // to retrieve all emp data.
    @GetMapping("/getemps")
    public List<Employee> getEmployees() {
//        log.info("this api is called");
//        log.warn("this is warn");
//        log.debug("Hello debug");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getempId/{id}")
    public Employee findEmpById(@PathVariable Integer id) {
        if(id == null) {
            log.error("Id is mandatory");
            throw new RuntimeException("Id is mandatory");
        }
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/createemployee")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);

    }

    // write a put request to update employee info.
    //

    @GetMapping("/findall")
    public List<Employee> getEmployeeWithSize(@RequestParam int page, @RequestParam int size) {
       return employeeService.getEmployeesBySize( page,size);
    }


}
