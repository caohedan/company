package com.oocl.company.service;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Company> companies = new ArrayList<>();
        for(Map.Entry<Long, Company> entry: companies.entrySet()) {
            Company company = entry.getValue();
            int id = entry.getKey();
            company.setEmployees(employeeService.getAllEmployeesByCompanyId(id));
            company.setEmployeesNumber(company.getEmployees().size());
            companies.add(company);
        }
        return companies;
    }

    public Company getCompanyById(int i) {
    }

    public List<Employee> getEmployeesByCompanyId(int i) {
    }

    public void updateCompany(int i, Company company1) {
    }

    public void deleteCompanyAndEmployeesByCompanyId(int i) {
    }
}
