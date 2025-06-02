package com.buymore.buymore.employee;

import com.buymore.buymore.department.Department;
import com.buymore.buymore.department.DepartmentRestRepository;
import com.buymore.user.User;
import com.buymore.user.UserRestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRestRepo employeeRestRepo;

    @Autowired
    private UserRestRepo userRestRepo;
    @Autowired
    private DepartmentRestRepository departmentRestRepository;

    public Employee createNewEmployee(Employee employee) {
        try {
            return userRestRepo.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Iterable<User> getAllEmployees() {
        try {
            return userRestRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public User getEmployeeById(Long id) {
        return userRestRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }





    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        User user = getEmployeeById(id);

        if (!(user instanceof Employee employee)) {
            throw new RuntimeException("User with id " + id + " is not an employee.");
        }
        employee.setEmployeeFirstName(updatedEmployee.getEmployeeFirstName());
        employee.setEmployeeLastName(updatedEmployee.getEmployeeLastName());
        employee.setUserName(updatedEmployee.getUserName());
        employee.setEmployeePhoneNumber(updatedEmployee.getEmployeePhoneNumber());
        employee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
        employee.setEmployeeAddress(updatedEmployee.getEmployeeAddress());

        if (updatedEmployee.getDepartmentsWorkedInStore() != null && !updatedEmployee.getDepartmentsWorkedInStore().isEmpty()) {
            List<Department> updatedDepartments = updatedEmployee.getDepartmentsWorkedInStore().stream()
                    .map(d -> departmentRestRepository.findDepartmentByDepartmentName(d.getDepartmentName()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            employee.setDepartmentsWorkedInStore(updatedDepartments);
        }

        System.out.println("Updated Employee: " + employee);
        return employeeRestRepo.save(employee);
    }


    public User addDepartmentToEmployee(Long employeeId, String departmentName) throws Exception {
        User user = userRestRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        if (!(user instanceof Employee employee)) {
            throw new RuntimeException("User with id " + employeeId + " is not an employee.");
        }

        Department department = departmentRestRepository.findDepartmentByDepartmentName(departmentName);
        if (department == null) {
            department = departmentRestRepository.save(new Department(departmentName));
        }

        if (employee.getDepartmentsWorkedInStore().contains(department)) {
            throw new Exception("Department " + departmentName + " is already assigned to employee with id: " + employeeId);
        }

        employee.getDepartmentsWorkedInStore().add(department);

        return userRestRepo.save(employee);
    }

}
