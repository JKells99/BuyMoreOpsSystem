package unittesting.buymoreidea;

import unittesting.buymoreidea.buymore.*;
import unittesting.buymoreidea.cia.*;

import java.time.LocalDateTime;

public class BuyMoreSystem {

    public static void main(String[] args) {
        Store store = new Store("BuyMore", "123 Main St", "555-1234");

        // Departments
        store.addDepartment(new Department("Electronics"));
        store.addDepartment(new Department("Software Engineering"));
        store.addDepartment(new Department("Hardware Engineering"));

        // Inventory Items
        store.addInventoryItem(new InventoryItem(new Department("Electronics"), "Laptop", "Laptop Computer", 1000.00, 10));
        store.addInventoryItem(new InventoryItem(new Department("Electronics"), "Phone", "Smart Phone", 500.00, 20));
        store.addInventoryItem(new InventoryItem(new Department("Electronics"), "Tablet", "Tablet Computer", 300.00, 15));
        store.addInventoryItem(new InventoryItem(new Department("Electronics"), "Monitor", "Computer Monitor", 200.00, 5));

        // Spy Base and Agents
        SpyBase spyBase = new SpyBase("USA", "TOP Secret", "Burbank Station");
        spyBase.addAgent(new Agent("UserName", "Password", "Darude", "OPS", "STG"));
        spyBase.addAgent(new Agent("UserName1", "Passwor1d", "Mark", "OPS", "Ground Branch"));
        spyBase.addDoor(new Door(11, "Main Entrance", "Open"));
        spyBase.addDoor(new Door(12, "Back Entrance", "Closed"));
        spyBase.openAllDoors();
        spyBase.generateReport();
        spyBase.printSpyBaseDetailsFormatted();

        // Gadgets
        spyBase.addNewgadget(new Gadget("Gadget1", "Des",",Surveillance",3,"Test Phase"));
        spyBase.addNewgadget(new Gadget("Gadget2", "Des",",Breaching",3,"Test Phase"));
        spyBase.printGadgetStockReport();
        spyBase.getitemStockCountByName("Gadget1");
        // Mission
        Mission mission = new Mission(1123, "Description of mission 1", "2023-10-01", "2023-10-31");
        mission.addAgent(new Agent("UserName", "Password", "Darude", "OPS", "STG"));
        mission.addAgent(new Agent("UserName1", "Passwor1d", "Mark", "OPS", "Ground Branch"));
        mission.printMissionDetails();

        // Employees and Shifts
        Employee emp1 = new Employee("alice123", "password1", "Alice", "Smith", "123-456-7890", "alice@example.com", "123 Main St", "Barista", 18.50);
        Employee emp2 = new Employee("bob456", "password2", "Bob", "Johnson", "234-567-8901", "bob@example.com", "456 Oak Ave", "Manager", 25.00);
        Employee emp3 = new Employee("clara789", "password3", "Clara", "Davis", "345-678-9012", "clara@example.com", "789 Pine Rd", "Cashier", 16.75);

        Schedule schedule = new Schedule();
        schedule.addShift(new Shift(LocalDateTime.of(2023, 10, 1, 8, 0), LocalDateTime.of(2023, 10, 1, 17, 0), emp1));
        schedule.addShift(new Shift(LocalDateTime.of(2023, 10, 1, 17, 0), LocalDateTime.of(2023, 10, 1, 23, 0), emp2));
        schedule.addShift(new Shift(LocalDateTime.of(2023, 10, 2, 8, 0), LocalDateTime.of(2023, 10, 2, 17, 0), emp3));

        store.setSchedule(schedule);
        store.setSpyBase(spyBase);
        store.getSchedule().printAllShiftFormatted();
    }
}