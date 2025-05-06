package unittesting.buymoreidea;

import unittesting.buymoreidea.buymore.Department;
import unittesting.buymoreidea.buymore.InventoryItem;
import unittesting.buymoreidea.buymore.Store;
import unittesting.buymoreidea.cia.Agent;
import unittesting.buymoreidea.cia.Door;
import unittesting.buymoreidea.cia.Mission;
import unittesting.buymoreidea.cia.SpyBase;

public class BuyMoreSystem {

    public static void main(String[] args) {
        Store store = new Store("BuyMore", "123 Main St", "555-1234");
        Department department = new Department("Electronics");
        Department department2 = new Department("Software Engineering");
        Department department3 = new Department("Hardware Engineering");


        InventoryItem inventoryItem = new InventoryItem(department, "Laptop","Laptop Computer", 1000.00, 10);
        InventoryItem inventoryItem2 = new InventoryItem(department, "Phone","Smart Phone", 500.00, 20);
        InventoryItem inventoryItem3 = new InventoryItem(department, "Tablet","Tablet Computer", 300.00, 15);
        InventoryItem inventoryItem4 = new InventoryItem(department, "Monitor","Computer Monitor", 200.00, 5);
        SpyBase spyBase = new SpyBase("USA", "TOP Secret", "Burbank Station");
        Agent agent = new Agent("UserName","Password","Darude","OPS","STG");
        Door door = new Door(11, "Main Entrance", "Open");
        Door door2 = new Door(12, "Back Entrance", "Closed");
        Mission mission = new Mission(1123, "Description of mission 1", "2023-10-01", "2023-10-31");

        agent.addMission(mission);
        store.setSpyBase(spyBase);
        store.addDepartment(department);
        store.addDepartment(department2);
        store.addDepartment(department3);
        store.addInventoryItem(inventoryItem);
        store.addInventoryItem(inventoryItem2);
        store.addInventoryItem(inventoryItem3);
        store.addInventoryItem(inventoryItem4);

        spyBase.addAgent(agent);
        spyBase.addDoor(door);
        spyBase.addDoor(door2);
        spyBase.openAllDoors();
        spyBase.generateReport();


//        System.out.println(store.getEmployees());;


    }

}
