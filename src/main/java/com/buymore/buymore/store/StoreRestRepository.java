package com.buymore.buymore.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRestRepository extends JpaRepository<Store, Long> {
}
