package com.springtechie.crud.endpoints;

import com.springtechie.crud.models.Employee;
import com.springtechie.crud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
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


    List<Employee> employees = new ArrayList<>();

    // to retrieve all emp data.
    @GetMapping("/getemps")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getempId/{id}")
    public Employee findEmpById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }


    // to create new resource.
    @PostMapping("/createemployee")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);

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

    @GetMapping("/findall")
    public List<Employee> getEmployeeWithSize(@RequestParam int page, @RequestParam int size) {
       return employeeService.getEmployeesBySize( page,size);
    }
}
