package com.example.demospring.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public EmployeeResponse[] getAll() {
        return new EmployeeResponse[] {
                new EmployeeResponse()
        };
    }
}
