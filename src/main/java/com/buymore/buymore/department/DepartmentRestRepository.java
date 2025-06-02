package com.buymore.buymore.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRestRepository extends JpaRepository<Department, Long> {
   Department findDepartmentByDepartmentName(String departmentName);

}
