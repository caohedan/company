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
    private EmployeeService employeeService ;
    public boolean add(Company company) {
        boolean result =false;
        List<Employee> employees = company.getEmployees();
        if(companies.put(company.getId(),company)== null)
        {
            result = true;
        }
        if(employees!=null)
        {
            for(Employee employee: employees){
                employeeService.add(employee);
            }
        }
        return result;
    }
    public List<Company> getAllCompanies(){
        List<Company> companiesList = new ArrayList<>();
        for(Map.Entry<Integer, Company> entry: companies.entrySet()) {
            Company company = entry.getValue();
            int id = company.getId();

            if(company.getEmployees() != null)
            {
                company.setEmployees(employeeService.getAllEmployeesByCompanyId(id));
                company.setEmployeesNumber(company.getEmployees().size());
            }

            companiesList.add(company);
        }
        return companiesList;
    }

    public Company getCompanyById(int id) {
        Company company = companies.get(id);
        if(company.getEmployees()!=null)
        {
            List<Employee> employees = employeeService.getAllEmployeesByCompanyId(id);
            company.setEmployees(employees);
            company.setEmployeesNumber(company.getEmployees().size());
        }

        return company;
    }

    public List<Employee> getEmployeesByCompanyId(int id) {
        return employeeService.findAllEmployees()
                .stream()
                .filter(e ->e.getCompanyId()==id)
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
        if(employeeService.findAllEmployees()!=null)
        {
            List<Integer> employeeIds = employeeService.findAllEmployees().stream()
                    .filter(u->u.getCompanyId()==id)
                    .map(u->u.getId())
                    .collect(Collectors.toList());
            for(Integer employeeId: employeeIds){
                employeeService.delete(employeeId);
            }
        }


         companies.remove(id);
    }
    private  List<Company> converMapToList(Map<Integer,Company>companies) {
        List<Company> companiesList = new ArrayList<>();
        for (Integer key : companies.keySet()) {
            companiesList.add (companies.get(key));
        }
        return companiesList;
    }

    public List<Company> getCompanyPagination(int page, int subsize) {
        List<Company>  employeesList = converMapToList(companies);
        //分页计算
        int fromIndex = (page-1) * subsize;
        int toIndex = (page*subsize > employeesList.size()) ? employeesList.size() : subsize ;
        List<Company> subList = employeesList.subList(fromIndex, toIndex);
        return subList;
    }
}
