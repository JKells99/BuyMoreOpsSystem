package com.buymore.buymore.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRestRepo extends JpaRepository<Employee, Long> {
}
