package com.example.demospring.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        EmployeeResponse[] result
                = restTemplate.getForObject("/employees", EmployeeResponse[].class);
        //Assert
        assertEquals(2, result.length);
        assertEquals(1, result[0].getId());
        assertEquals("Supachet", result[0].getName());
    }

    @Test
    void getEmployeeById() {
        int id = 100;
        EmployeeResponse result
                = restTemplate.getForObject("/employees/"+id, EmployeeResponse.class);
        //Assert
        assertEquals(100, result.getId());
        assertEquals( "Supachet", result.getName());
    }

}