package com.example.demospring.employees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@Import(EmployeeRepository.class)
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("ค้นหาข้อมูลสำเร็จ id = 100")
    public void case01() {
        int id = 1;
        Employee employee100 = new Employee();
        employee100.setName("MockName");
        employeeRepository.save(employee100);
        Optional<Employee> result = employeeRepository.findById(id);
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
    }

    @Test
    @DisplayName("ค้นหาข้อมูล id = 1 ไม่เจอ")
    public void case02() {
        int id = 1;
        Employee employee200 = new Employee();
        employee200.setName("MockNam 2");
        employeeRepository.save(employee200);
        Optional<Employee> result = employeeRepository.findById(id);
        assertFalse(result.isPresent());
    }
}