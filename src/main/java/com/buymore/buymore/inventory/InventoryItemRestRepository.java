package com.buymore.buymore.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRestRepository extends JpaRepository<InventoryItem, Long> {
}
