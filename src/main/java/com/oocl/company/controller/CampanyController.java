package com.oocl.company.controller;

import com.oocl.company.model.Company;
import com.oocl.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping(path="/companies")
    public boolean addEmployee(@RequestBody Company company){
        return companyService.add(company);
    }
}
