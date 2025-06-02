package com.buymore.buymore.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRestRepository departmentRestRepository;

    public Iterable<Department> getAllDepartments() {
       return departmentRestRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    public void createANewDepartment(Department department) {
        try {
            departmentRestRepository.save(department);
        } catch (Exception e) {
            throw new RuntimeException("Error creating department: " + e.getMessage());
        }
    }
}
