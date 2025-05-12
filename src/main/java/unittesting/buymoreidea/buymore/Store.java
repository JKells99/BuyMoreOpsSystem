package unittesting.buymoreidea.buymore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unittesting.buymoreidea.cia.SpyBase;

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
    private SpyBase spyBase;
    Schedule schedule = new Schedule();

    public Store(String storeName, String storeAddress, String storePhoneNumber) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;
        this.spyBase = new SpyBase();
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

    public SpyBase getSpyBase() {
        return spyBase;
    }

    public void setSpyBase(SpyBase spyBase) {
        this.spyBase = spyBase;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

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
    public void checkItemStock(String itemName) {
        for (InventoryItem item : inventoryItems) {
            if (item.getItemName().equals(itemName)) {
                System.out.println("Item " + itemName + " is in stock with quantity " + item.getItemQuantity());
                log.info("Item {} is in stock with quantity {}", itemName, item.getItemQuantity());
                return;
            }
        }
        log.warn("Item {} is not in stock", itemName);
    }
    public void checkEmployeeContactInfo(String employeeName, String employeeLastName) {
        for (Employee employee : employees) {
            if (employee.getEmployeeFirstName().equals(employeeName) && employee.getEmployeeLastName().equals(employeeLastName)) {
                System.out.println("Employee " + employeeName + " contact info: " + employee.getEmployeePhoneNumber());
                log.info("Employee {} contact info: {}", employeeName , "Has Been Accessed");
                return;
            }
        }
        log.warn("Employee {} not found", employeeName);
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