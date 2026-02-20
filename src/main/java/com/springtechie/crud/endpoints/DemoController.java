package com.springtechie.crud.endpoints;

import com.springtechie.crud.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {

    List<Employee> employees = new ArrayList<>();
    // to retrieve all emp data
    @GetMapping("/getemps")
    public List<Employee> getEmployees() {
        return employees;
    }
    // client want to search with empId.

    @GetMapping("/getempId/{id}/{name}")
    public Employee findEmpById(@PathVariable int id) {
        Optional<Employee> emp = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if(emp.isPresent()) {
            return emp.get();
        }
       return null;
    }


    // to create new resource
    @PostMapping("/createemployee")
    public String createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return "Account created Successully";
    }

    @DeleteMapping("/delete/all/emps")
    public String deleteEmpls() {
        employees.clear();
        return "Emp data removed successfully";
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteEmp(@PathVariable int id) {
        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
        employees.remove(employee);

        return "Emp data removed successfully";
    }

    @PutMapping("/update/{perc}")
    public List<Employee> updateEmps(@PathVariable int perc) {

        List<Employee> updateList = new ArrayList<>();
        for(Employee employee : employees) {
            employee.setSalary(employee.getSalary() * 1.10);
            updateList.add(employee);
        }
        employees = updateList;
        return employees;
    }
    @PutMapping("/update/id/{id}")
    public String updateEmpById(@PathVariable int id) {

        for(Employee employee : employees) {
            if(employee.getId() == id) {
                employee.setSalary(employee.getSalary() * 1.10);

            }
        }
        return "Data updated successfully";

    }
}
