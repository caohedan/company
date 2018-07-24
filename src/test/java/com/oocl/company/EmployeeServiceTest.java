package com.oocl.company;

import com.oocl.company.model.Employee;
import com.oocl.company.service.EmployeeService;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.util.List;
import static org.hamcrest.Matchers.nullValue;
public class EmployeeServiceTest {
    EmployeeService employeeService;
    @Test
    public  void  should_return_true_when_add_emplpyee_success(){
        employeeService = new EmployeeService();
        Employee employee =  new Employee(1,4,"小霞", 15, "female",3000);
        boolean result = employeeService.add(employee);
        assertThat(result,is(true));
    }
    @Test
    public  void  should_return_false_when_add_a_exist_emplpyee(){
        employeeService = new EmployeeService();
        Employee employee =  new Employee(1,4,"小霞", 15, "female",3000);
        employeeService.add(employee);
        boolean result = employeeService.add(employee);
        assertThat(result,is(false));
    }

    @Test
    public  void should_return_true_when_delete_a_exist_employee(){
        employeeService = new EmployeeService();
        employeeService.add(new Employee(1,4,"小霞", 15, "female",3000));
        boolean result = employeeService.delete(4);
        assertThat(result,is(true));
    }
    @Test
    public  void should_return_false_when_delete_a_not_exist_employee(){
        employeeService = new EmployeeService();
        employeeService.add(new Employee(1,4,"小霞", 15, "female",3000));
        boolean result = employeeService.delete(3);
        assertThat(result,is(false));
    }
    @Test
    public void should_return_size_3_when_add_3_employee_and_execute_findAllEmployees()
    {
        employeeService = new EmployeeService();
        employeeService.add(new Employee(1,1,"小霞1", 15, "female",3000));
        employeeService.add(new Employee(1,2,"小霞2", 15, "female",3000));
        employeeService.add(new Employee(1,3,"小霞3", 15, "female",3000));
        List<Employee> result = employeeService.findAllEmployees();
        assertThat(result.size(),is(3));
    }
    @Test
    public void should_return_specify_employee_when_find_employee_by_correct_id()
    {
        employeeService = new EmployeeService();
        Employee employee =  new Employee(1,4,"小霞", 15, "female",3000);
        employeeService.add(employee);
        Employee result = employeeService.findEmployeeById(4);
        assertThat(result,is(employee));
    }
    @Test
    public void should_return_null_employee_when_find_employee_by_not_exist_id()
    {
        employeeService = new EmployeeService();
        Employee employee =  new Employee(1,4,"小霞", 15, "female",3000);
        employeeService.add(employee);
        Employee result = employeeService.findEmployeeById(1);
        assertThat(result,is(nullValue()));
    }
    @Test
    public void should_return_specify_employee_when_update_it_success(){
        employeeService = new EmployeeService();
        Employee employee =  new Employee(1,1,"小霞", 15, "female",3000);
        employeeService.add(new Employee(1,1,"小霞1", 15, "female",3000));
       Employee result = employeeService.updateEmployee(1,employee);
        assertThat(result,is(employee));
    }
    @Test
    public void should_return_all_man_employee_when_findManEmployees(){
        employeeService = new EmployeeService();
        employeeService.add(new Employee(1,4,"小霞", 15, "female",3000));
        employeeService.add(new Employee(1,1,"小明", 15, "male",3000));
        List<Employee> result = employeeService.findManEmployees("male");
        assertThat(result.size(),is(1));
    }
    @Test
    public void should_return_the_size_is_one_when_Employees_is_3_page_2_pageSize_2(){
        employeeService = new EmployeeService();
        employeeService.add(new Employee(1,1,"小霞", 15, "female",3000));
        employeeService.add(new Employee(1,2,"小明", 15, "male",3000));
        employeeService.add(new Employee(1,3,"小李", 15, "male",3000));
        List<Employee> result = employeeService.getEmployeesPagination(2,2);
        assertThat(result.size(),is(1));
    }
}
