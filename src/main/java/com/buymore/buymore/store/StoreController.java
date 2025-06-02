package com.buymore.buymore.store;

import com.buymore.buymore.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.createNewStore(store), HttpStatus.CREATED);
    }

    @GetMapping("/allStores")
    public ResponseEntity<Iterable<Store>> getAllStores() {
        return new ResponseEntity<>(storeService.getAllStores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        return new ResponseEntity<>(storeService.getStoreById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStoreById(@PathVariable Long id) {
        storeService.deleteStoreById(id);
        return new ResponseEntity<>("Store with id"  + id + " has been deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store store) {
        Store updatedStore = storeService.updateStore( id,store);
        return new ResponseEntity<>(updatedStore, HttpStatus.OK);
    }


}

