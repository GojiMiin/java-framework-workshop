package com.example.demospring.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse getById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()){
            EmployeeResponse response = new EmployeeResponse();
            response.setId(result.get().getId());
            response.setName(result.get().getName());
            return response;
        }
        throw new RuntimeException("Employee not found id = " +id);
    }
}
