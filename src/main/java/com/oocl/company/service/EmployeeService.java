package com.oocl.company.service;

import com.oocl.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private Map<Integer,Employee> employees = new HashMap<>() ;
    public EmployeeService() {

    }

    public boolean add(Employee employee){
       if(employees.put(employee.getId(),employee)== null)
       {
           return true;
       }

       return false;
    }

    public List<Employee> findAllEmployees() {
        return converMapToList(employees);
    }

    private  List<Employee> converMapToList(Map<Integer,Employee>employees) {
        List<Employee> employeesList = new ArrayList<>();
        for (Integer key : employees.keySet()) {
            employeesList.add (employees.get(key));
        }
        return employeesList;
    }

    public Employee findEmployeeById(int id) {
        return employees.get(id);
    }

    public  boolean delete(int employeeId) {

       if(employees.remove(employeeId)!=null)
           return true;
       return false;
    }

    public Employee updateEmployee(int id,Employee employee) {
        employees.replace(id,employee);
        return employees.get(employee.getId());
    }


    public List<Employee> findManEmployees(String male) {
        return null;
    }

    public List<Employee> getEmployeesPagination(int i, int i1) {
        return null;
    }
}
