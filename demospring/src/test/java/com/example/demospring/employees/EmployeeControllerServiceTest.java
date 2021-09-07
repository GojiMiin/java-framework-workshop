package com.example.demospring.employees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Test
    @DisplayName("Success Case")
    void getEmployeeById() {
        int id = 1;
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Supachet");
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Employee employee001 = new Employee();
        employee001.setName("Supachet");
        employeeRepository.save(employee001);

        EmployeeResponse result
                = restTemplate.getForObject("/employees/"+id, EmployeeResponse.class);
        //Assert
        assertEquals(1, result.getId());
        assertEquals( "Supachet", result.getName());
    }

}
