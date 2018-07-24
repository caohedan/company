package com.oocl.company;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import com.oocl.company.service.CompanyService;
import com.oocl.company.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class CompanyServiceTest {
    CompanyService companyService ;
    List<Employee> employeeList;
    @BeforeEach
    public void setUp(){
         List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(1,1,"小霞1", 15, "female",3000),
                new Employee(1,2,"小霞2", 15, "female",3000),
                new Employee(1,3,"小霞3", 15, "female",3000),
                new Employee(1,4,"小霞4", 15, "female",3000),
                new Employee(1,5,"小霞5", 15, "female",3000)));
    }
    @Test
    public  void  should_return_true_when_add_company_success(){
        companyService = new CompanyService();
        Company company =  new Company();
        boolean result = companyService.add(company);
        assertThat(result,is(true));
    }
    @Test
    public  void  should_return_false_when_add_a_exist_company(){
        companyService = new CompanyService();
        Company company =  new Company();
        companyService.add(company);
        boolean result = companyService.add(company);
        assertThat(result,is(false));
    }

}
