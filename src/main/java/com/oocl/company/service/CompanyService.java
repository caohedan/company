package com.oocl.company.service;

import com.oocl.company.model.Company;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CompanyService {
    Map<Integer,Company> companies = new HashMap<>();
    public boolean add(Company company) {

        if(companies.put(company.getId(),company)== null)
        {
            return true;
        }

        return false;
    }
}
