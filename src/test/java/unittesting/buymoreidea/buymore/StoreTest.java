package unittesting.buymoreidea.buymore;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unittesting.buymoreidea.cia.SpyBase;

import java.time.LocalDateTime;

public class StoreTest {
    Employee employee;
    Employee employee2;
    Department department;
    Store store;
    Schedule schedule;
    SpyBase spyBase;

    @BeforeEach
    public void setUp() {
        employee = new Employee("alice123", "password1", "Alice", "Smith", "123-456-7890", "alice@example.com", "123 Main St", "Barista", 18.50);
        employee2 = new Employee("bob123", "password2", "Bob", "Johnson", "234-567-8901", "j@b.com", "456 Oak Ave", "Manager", 25.00);
        department = new Department("Home Appliances");
        store = new Store("BuyMore", "123 Main St", "123-456-7890");
        schedule = new Schedule();
        spyBase = new SpyBase("USA", "TOP Secret", "Burbank Station");
        schedule.addShift(new Shift(LocalDateTime.now(), LocalDateTime.now().plusHours(8), employee));
        schedule.addShift(new Shift(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(8), employee2));
        store.setSchedule(schedule);
        store.setSpyBase(spyBase);
        store.addDepartment(department);
        store.addEmployee(employee);
        store.addEmployee(employee2);
    }
    @AfterEach
    public void tearDown() {
        employee = null;
        employee2 = null;
        department = null;
        store = null;
        schedule = null;
        spyBase = null;
    }

    @Test
    public void testStoreCreation() {
        Assertions.assertEquals("BuyMore", store.getStoreName());
        Assertions.assertEquals("123 Main St", store.getStoreAddress());
        Assertions.assertEquals("123-456-7890", store.getStorePhoneNumber());
        Assertions.assertFalse(store.schedule.getListOfShifts().isEmpty());
        Assertions.assertFalse(store.getDepartments().isEmpty());
        Assertions.assertNotNull(store.getSpyBase());
        Assertions.assertNotNull(store.getSpyBase().getLocation());

    }

    @Test
    public void testAddDepartment() {
        Department newDepartment = new Department("Electronics");
        store.addDepartment(newDepartment);
        Assertions.assertTrue(store.getDepartments().contains(newDepartment));
    }

    @Test
    public void testAddEmployee() {
        Employee emp3 = new Employee("Bob John", "password2", "Bob", "Johnsonnn", "234-567-8901", "j@bbb.com", "456 Oak Ave", "Manager", 25.00);
        store.addEmployee(emp3);
        Assertions.assertTrue(store.getEmployees().contains(emp3));
    }

    @Test
    public void testAddInventoryItem() {
        InventoryItem item = new InventoryItem(department, "Washing Machine", "Top Load Washer", 499.99, 10);
        store.addInventoryItem(item);
        Assertions.assertTrue(store.getInventoryItems().contains(item));
    }
    @Test
    public void testRemoveDepartment() {
        store.removeDepartment(department);
        Assertions.assertFalse(store.getDepartments().contains(department));
    }
    @Test
    public void testRemoveEmployee() {
        store.removeEmployee(employee);
        Assertions.assertFalse(store.getEmployees().contains(employee));
    }

    @Test
    public void testRemoveInventoryItem() {
        InventoryItem item = new InventoryItem(department, "Washing Machine", "Top Load Washer", 499.99, 10);
        store.addInventoryItem(item);
        store.removeInventoryItem(item);
        Assertions.assertFalse(store.getInventoryItems().contains(item));
    }
    @Test
    public void testGetDepartments() {
        Assertions.assertNotNull(store.getDepartments());
        Assertions.assertFalse(store.getDepartments().isEmpty());
    }
    @Test
    public void testGetEmployees() {
        Assertions.assertNotNull(store.getEmployees());
        Assertions.assertFalse(store.getEmployees().isEmpty());
    }
    @Test
    public void testGetInventoryItems() {
        InventoryItem item = new InventoryItem(department, "Washing Machine", "Top Load Washer", 499.99, 10);
        store.addInventoryItem(item);
        Assertions.assertNotNull(store.getInventoryItems());
        Assertions.assertFalse(store.getInventoryItems().isEmpty());
    }
    @Test
    public void testGetSpyBase() {
        Assertions.assertNotNull(store.getSpyBase());
        Assertions.assertEquals("USA", store.getSpyBase().getLocation());
    }
    @Test
    public void testGetSchedule() {
        Assertions.assertNotNull(store.getSchedule());
        Assertions.assertFalse(store.getSchedule().getListOfShifts().isEmpty());
    }
    @Test
    public void testAddNullDepartment() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            store.addDepartment(null);
        });
    }


}
