package com.buymore.buymore.store;

import com.buymore.buymore.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRestRepository storeRestRepository;

    public StoreService(StoreRestRepository storeRestRepository) {
        this.storeRestRepository = storeRestRepository;

    }

    public Store createNewStore(Store store) {
        try {
            return storeRestRepository.save(store);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<Store> getAllStores() {
        try {
            return storeRestRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Store getStoreById(Long id) {
        return storeRestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
    }
    public void deleteStoreById(Long id) {
        if (storeRestRepository.existsById(id)) {
            storeRestRepository.deleteById(id);
        } else {
            throw new RuntimeException("Store not found with id: " + id);
        }
    }

    public Store updateStore(Long id, Store store) {
        if (!storeRestRepository.existsById(id)) {
            throw new RuntimeException("Store not found with id: " + id);
        }
        return storeRestRepository.save(store);

    }


}
