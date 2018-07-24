package com.oocl.company.controller;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import com.oocl.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CampanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping(path = "/companies")
    public boolean addCompany(@RequestBody Company company) {
        return companyService.add(company);
    }

    @GetMapping(path = "/companies")
    public List<Company> getCompanies(){
        return companyService.getAllCompanies();
    }


    @GetMapping(path = "/companies/{companyId}")
    public Company getCompanyById(@PathVariable int companyId) {
        return companyService.getCompanyById(companyId);
    }

    @GetMapping(path = "/companies/{companyId}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable int companyId) {
        return companyService.getEmployeesByCompanyId(companyId);
    }

    @PutMapping(path = "/companies/{companyId}")
    public Company updateCompanyById(@PathVariable int companyId, @RequestBody Company company) {
        return companyService.updateCompany(companyId, company);
    }

    @DeleteMapping(path = "companies/{companyId}")
    public  void deleteCompanyAndEmployeesByCompanyId(@PathVariable int companyId) {
        companyService.deleteCompanyAndEmployeesByCompanyId(companyId);
    }


    @GetMapping(path = "companies/page/{page}/pageSize/{size}")
    public List<Company> getCompanyPagination(@PathVariable int page, @PathVariable int size){
        return companyService.getCompanyPagination(page, size);
    }
}
