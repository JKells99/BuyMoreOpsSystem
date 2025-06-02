package com.buymore.buymore.store;

import com.buymore.buymore.employee.Employee;
import com.buymore.buymore.schedule.Schedule;
import com.buymore.buymore.department.Department;
import com.buymore.buymore.inventory.InventoryItem;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.buymore.cia.spybase.SpyBase;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Store {

    private static final Logger log = LoggerFactory.getLogger(Store.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;
    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    @OneToMany
    private List<Department> departments = new ArrayList<>();
    @OneToMany
    private List<Employee> employees = new ArrayList<>();
    @OneToMany
    private List<InventoryItem> inventoryItems = new ArrayList<>();
    @OneToOne
    private SpyBase spyBase = new SpyBase();
    @OneToMany
    private List<Schedule> schedules = new ArrayList<>();

    public Store(long storeId,String storePhoneNumber, String storeAddress, String storeName) {
        this.storeId = storeId;
        this.inventoryItems = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.storePhoneNumber = storePhoneNumber;
        this.storeAddress = storeAddress;
        this.storeName = storeName;

    }

    public Store(String storeName, String storeAddress, String storePhoneNumber) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;

    }

    public Store() {}

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public String getStoreAddress() { return storeAddress; }
    public void setStoreAddress(String storeAddress) { this.storeAddress = storeAddress; }
    public String getStorePhoneNumber() { return storePhoneNumber; }
    public void setStorePhoneNumber(String storePhoneNumber) { this.storePhoneNumber = storePhoneNumber; }
    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
    public List<InventoryItem> getInventoryItems() { return inventoryItems; }
    public void setInventoryItems(List<InventoryItem> inventoryItems) { this.inventoryItems = inventoryItems; }

    public SpyBase getSpyBase() {
        return spyBase;
    }

    public void setSpyBase(SpyBase spyBase) {
        this.spyBase = spyBase;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhoneNumber='" + storePhoneNumber + '\'' +
                ", departments=" + departments +
                ", employees=" + employees +
                ", inventoryItems=" + inventoryItems +
                ", spyBase=" + spyBase +
                '}';
    }
}