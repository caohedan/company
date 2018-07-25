package com.oocl.company;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import com.oocl.company.service.CompanyService;
import com.oocl.company.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;


public class CompanyServiceTest {

//    private CompanyService companyService ;
    private List<Employee> employeeList;

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    CompanyService companyService = new CompanyService();

    @Before
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }
    @Before
    public void setUp(){
        employeeList = new ArrayList<>(Arrays.asList(
                new Employee(1,1,"小霞1", 15, "female",3000),
                new Employee(1,2,"小霞2", 15, "female",3000),
                new Employee(1,3,"小霞3", 15, "female",3000),
                new Employee(1,4,"小霞4", 15, "female",3000),
                new Employee(1,5,"小霞5", 15, "female",3000)));
    }
    @Test
    public  void  should_return_true_when_add_company_success(){
        Company company =  new Company();
        boolean result = companyService.add(company);
        assertThat(result,is(true));
    }
    @Test
    public  void  should_return_false_when_add_a_exist_company(){
        Company company =  new Company();
        companyService.add(company);
        boolean result = companyService.add(company);
        assertThat(result,is(false));
    }
 @Test
    public void should_return_all_companies_when_call_showAllCompanies(){
     Company company1 =  new Company();
     company1.setId(1);
     Company company2 =  new Company();
     company2.setId(2);
     companyService.add(company1);
     companyService.add(company2);
     List<Company> companies = companyService.getAllCompanies();
     int result = companies.size();
     assertThat(result,is(2));
 }
 @Test
    public void should_return_specify_company_when_call_findCompanyById(){
     Company company1 =  new Company();
     company1.setId(1);
     companyService.add(company1);
     Company company2 = companyService.getCompanyById(1);
     assertThat(company1,is(company2));
 }
 @Test
    public void should_delete_employees_when_delete_Company(){
     Company company1 =  new Company();
     company1.setId(1);
     System.out.println(employeeList);
     company1.setEmployees(employeeList);
     companyService.add(company1);
     companyService.deleteCompanyAndEmployeesByCompanyId(1);
     List<Company> result = companyService.getAllCompanies();
     assertThat(result.size(),is(0));
 }

}
