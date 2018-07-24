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
    EmployeeService employeeService = new EmployeeService();
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



}
