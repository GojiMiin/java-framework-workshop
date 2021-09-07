package com.example.demospring.employees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void success_case() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mock Name");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        EmployeeResponse result = employeeService.getById(1);
        assertEquals(1, result.getId());
        assertEquals("Mock Name", result.getName());
    }

    @Test
    public void employee_not_found() {

        when(employeeRepository.findById(1)).thenReturn(Optional.empty());

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        try{
            employeeService.getById(1);
            fail();
        } catch (Exception e) {
            if(!"".equals(e.getMessage())){
                fail("Message fail with = " + e.getMessage());
            }
        }
    }

}