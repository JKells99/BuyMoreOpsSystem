package com.buymore.buymore.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRestRepo employeeRestRepo;
    public Employee createNewEmployee(Employee employee) {
        try {
            return employeeRestRepo.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Iterable<Employee> getAllEmployees() {
        try {
            return employeeRestRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Employee getEmployeeById(Long id) {
        return employeeRestRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
}
