package com.oocl.company.service;

import com.oocl.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    private Map<Integer,Employee> employees = new HashMap<>() ;
    public EmployeeService() {
        employees = new HashMap<>();
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
     List<Employee>  employeesList = converMapToList(employees);
        List<Employee>  tempList = new ArrayList<>();
        employeesList.stream().forEach(employee -> {
                if(employee.getGender().equals(male))
                    tempList.add(employee);
        });
     return tempList ;
    }

    public List<Employee> getEmployeesPagination(int page, int subsize) {
        List<Employee>  employeesList = converMapToList(employees);
        //分页计算
            int fromIndex = (page-1) * subsize;
            int toIndex = (page*subsize > employeesList.size()) ? employeesList.size() : subsize ;
            List<Employee> subList = employeesList.subList(fromIndex, toIndex);
            return subList;

    }

    public List<Employee> getAllEmployees() {
        if(employees.isEmpty()) return null;
        List<Employee> emp = new ArrayList<>();
        for(Map.Entry<Integer, Employee> entry :employees.entrySet()){
            emp.add(entry.getValue());
        }
        return emp;
    }
}
