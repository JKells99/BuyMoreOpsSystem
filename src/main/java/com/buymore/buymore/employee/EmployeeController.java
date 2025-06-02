package com.buymore.buymore.employee;

import com.buymore.user.User;
import com.buymore.user.UserRestRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public Iterable<User> getAllEmployees() {

        try {
            return employeeService.getAllEmployees();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee employee) {
        try {
            employee.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
            return employeeService.createNewEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            return employeeService.updateEmployee(id, employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("addDepartment/{employeeId}")
    public User addDepartmentToEmployee(@PathVariable Long employeeId, @RequestParam String departmentName) {
        try {
            return employeeService.addDepartmentToEmployee(employeeId, departmentName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
