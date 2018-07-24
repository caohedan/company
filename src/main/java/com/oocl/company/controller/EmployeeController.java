package com.oocl.company.controller;

import com.oocl.company.model.Employee;
import com.oocl.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path="/employees")
    public boolean addEmployee(@RequestBody Employee employee){
        return employeeService.add(employee);
    }
    @GetMapping(path="/employees")
    public List<Employee> findAllEmployees(){
        return  employeeService.findAllEmployees();
    }
    @GetMapping(path="/employees/{employeeId}")
    public Employee findEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId);
        return  employee;
    }
    @DeleteMapping(path="/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        employeeService.delete(employeeId);
    }
    @PutMapping(path="employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee)
    {
        return  employeeService.updateEmployee(employeeId,employee);

    }




}