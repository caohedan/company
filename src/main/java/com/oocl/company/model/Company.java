package com.oocl.company.model;

import com.oocl.company.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Company {
    private int id;
    private String companyName;
    private String employeesNumber;
    private List<Employee> employees;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(String employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}