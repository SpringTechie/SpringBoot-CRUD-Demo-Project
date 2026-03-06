package com.springtechie.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    private  int id;
    private String fname;
    private String lname;
    private double salary;

    public Employee(int id, String fname, String lname, double salary) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }
    public Employee() {

    }
}
