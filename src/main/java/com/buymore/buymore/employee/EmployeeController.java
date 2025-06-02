package com.buymore.buymore.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public Iterable<Employee> getAllEmployees() {

        try {
            return employeeService.getAllEmployees();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) {
        try {
            return employeeService.createNewEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
