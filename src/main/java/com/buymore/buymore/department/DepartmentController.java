package com.buymore.buymore.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/allDepartments")
    public Iterable<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentById(id);
    }
    @PostMapping
    public void createANewDepartment(Department department) {
        departmentService.createANewDepartment(department);
    }
}
