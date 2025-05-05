package unittesting.buymoreidea;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor

@NoArgsConstructor
public class Store {
    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    private List<Department> departments;
    private List<Employee> employees;
    private List<InventoryItem> inventoryItems;

    public Store(String storeName, String storeAddress, String storePhoneNumber) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.inventoryItems = new ArrayList<>();
    }


    public void addDepartment(Department department) {
        departments.add(department);
    }
    public void removeDepartment(Department department) {
        departments.remove(department);
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
    public void addInventoryItem(InventoryItem inventoryItem) {
        inventoryItems.add(inventoryItem);
    }
    public void removeInventoryItem(InventoryItem inventoryItem) {
        inventoryItems.remove(inventoryItem);
    }
    public void displayStoreInfo() {
        System.out.println("Store Name: " + storeName);
        System.out.println("Store Address: " + storeAddress);
        System.out.println("Store Phone Number: " + storePhoneNumber);
        System.out.println("Departments: ");
        departments.forEach(department -> System.out.println(" - " + department.getDepartmentName()));;
        System.out.println("Employees: ");
        employees.forEach(employee -> System.out.println(" - " + employee.getEmployeeFirstName() + " " + employee.getEmployeeLastName()));
    }


}
