package unittesting.buymoreidea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static final Logger log = LoggerFactory.getLogger(Store.class);
    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<InventoryItem> inventoryItems = new ArrayList<>();

    public Store(String storeName, String storeAddress, String storePhoneNumber) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;
    }

    public Store() {}

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

    public void addDepartment(Department department) {
        validateNotNull(department, "Department");
        if (departments.contains(department)) throw new IllegalArgumentException("Department already exists");
        log.info("Adding department {}", department.getDepartmentName());
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        validateNotNull(department, "Department");
        log.info("Removing department {}", department);
        departments.remove(department);
    }

    public void addEmployee(Employee employee) {
        validateNotNull(employee, "Employee");
        if (employees.contains(employee)) throw new IllegalArgumentException("Employee already exists");
        log.info("Adding employee {}", employee);
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        validateNotNull(employee, "Employee");
        log.info("Removing employee {}", employee);
        employees.remove(employee);
    }

    public void addInventoryItem(InventoryItem inventoryItem) {
        validateNotNull(inventoryItem, "Inventory item");
        if (inventoryItems.contains(inventoryItem)) throw new IllegalArgumentException("Inventory item already exists");
        log.info("Adding inventory item {}", inventoryItem.getItemName());
        inventoryItems.add(inventoryItem);
    }

    public void removeInventoryItem(InventoryItem inventoryItem) {
        validateNotNull(inventoryItem, "Inventory item");
        log.info("Removing inventory item {}", inventoryItem);
        inventoryItems.remove(inventoryItem);
    }

    private void validateNotNull(Object obj, String name) {
        if (obj == null) throw new IllegalArgumentException(name + " cannot be null");
    }
}