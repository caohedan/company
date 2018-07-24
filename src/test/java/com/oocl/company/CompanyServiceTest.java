package com.oocl.company;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import com.oocl.company.service.CompanyService;
import com.oocl.company.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyServiceTest {
    @InjectMocks
    CompanyService companyService = new CompanyService();
    @Mock
    EmployeeService employeeService;
    @Test
    public void should_return_true_when_add_company_success() {
        // given
        Company company = mock(Company.class);
        boolean result = companyService.add(company);
        assertThat(result, is(true));
    }

    @Test
    public void should_return_false_when_add_a_exist_company() {
        Company company = mock(Company.class);
        companyService.add(company);
        boolean result = companyService.add(company);
        assertThat(result, is(false));
    }

    @Test
    public void should_return_specify_company_when_call_getCompanyById(){
        // given
        Company company = mock(Company.class);
        when(company.getId()).thenReturn(1);
        // when
        Company company1 = companyService.getCompanyById(1);
        // then
        assertThat(company, is(company1));
    }
//
    @Test
    public void should_return_all_employees_when_getEmployeesByCompanyId(){
        // given
        Company company = mock(Company.class);
        Employee employee = mock(Employee.class);
        when(employee.getCompanyId()).thenReturn(1);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        when(company.getId()).thenReturn((1));
        when(employeeService.getAllEmployeesByCompanyId(1)).thenReturn(employees);
        companyService.add(company);
        // when
        List<Employee> employees1 = companyService.getEmployeesByCompanyId(1);
        // then
        assertEquals(1, is(employees1.get(0).getCompanyId()));
    }

    @Test
    public void should_update_the_company_when_updateCompany(){
        // given
        Company company = mock(Company.class);
        when(company.getId()).thenReturn(1);
        when(company.getCompanyName()).thenReturn("company1");
        Company company1 = mock(Company.class);
        when(company1.getCompanyName()).thenReturn("company2");

        companyService.add(company);
        // when
        companyService.updateCompany(1, company1);
        // then
        assertThat(company1, is(companyService.getCompanyById(1)));
    }

    @Test
    public void should_delete_the_company_when_deleteCompanyAndEmployeesByCompanyId(){
        // given
        Employee employee = mock(Employee.class);
        when(employee.getCompanyId()).thenReturn((1));
        when(employee.getId()).thenReturn(0);
        Company company = mock(Company.class);
        when(company.getId()).thenReturn((1));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        companyService.add(company);
        // when
        companyService.deleteCompanyAndEmployeesByCompanyId(1);
        Employee employee1 = employeeService.findEmployeeById(employee.getId());
        // then

        assertEquals(null, employee1);
    }

}
