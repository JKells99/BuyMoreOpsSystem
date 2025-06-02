package com.buymore.buymore.store;

import com.buymore.buymore.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRestRepository extends JpaRepository<Store, Long> {
}
