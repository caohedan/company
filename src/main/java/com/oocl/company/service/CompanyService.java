package com.oocl.company.service;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    Map<Integer,Company> companies = new HashMap<>();
    @Autowired
    private EmployeeService employeeService;
    public boolean add(Company company) {

        if(companies.put(company.getId(),company)== null)
        {
            return true;
        }

        return false;
    }

    public List<Company> getAllCompanies(){
        List<Company> companiesList = new ArrayList<>();
        for(Map.Entry<Integer, Company> entry: companies.entrySet()) {
            Company company = entry.getValue();
            int id = entry.getKey();
            company.setEmployees(employeeService.getAllEmployeesByCompanyId(id));
            company.setEmployeesNumber(company.getEmployees().size());
            companiesList.add(company);
        }
        return companiesList;
    }

    public Company getCompanyById(int id) {
        Company company = companies.get(id);
        List<Employee> employees = employeeService.findAllEmployees()
                .stream()
                .filter(u ->u.getCompanyId()==id)
                .collect(Collectors.toList());

        company.setEmployees(employees);
        company.setEmployeesNumber(company.getEmployees().size());
        return company;
    }

    public List<Employee> getEmployeesByCompanyId(int id) {
        return employeeService.findAllEmployees()
                .stream()
                .filter(u ->u.getCompanyId()==id)
                .collect(Collectors.toList());
    }

    public Company updateCompany(int id, Company company) {
        List<Employee> employees = company.getEmployees();

        companies.put(id, company);

        for(Employee employee: employees){
            employeeService.add(employee);
        }

        return company;
    }

    public void deleteCompanyAndEmployeesByCompanyId(int id) {
        List<Integer> employeeIds = employeeService.findAllEmployees().stream()
                .filter(u->u.getCompanyId()==id)
                .map(u->u.getId())
                .collect(Collectors.toList());
        for(Integer employeeId: employeeIds){
            employeeService.delete(employeeId);
        }

         companies.remove(id);
    }
}
