package unittesting.buymoreidea;

public class BuyMoreSystem {

    public static void main(String[] args) {
        Store store = new Store("BuyMore", "123 Main St", "555-1234");
        Department department = new Department("Electronics");
        Department department2 = new Department("Software Engineering");
        Department department3 = new Department("Hardware Engineering");
        Employee employee = new Employee("John","Doe", "555-5678", "j@j.com", "1234", "Manager", 50000);
        Employee employee2 = new Employee("Jane","Doe", "545-5678", "j@jd.com", "1234", "Floor", 50000);

        InventoryItem inventoryItem = new InventoryItem(department, "Laptop","Laptop Computer", 1000.00, 10);
        InventoryItem inventoryItem2 = new InventoryItem(department, "Phone","Smart Phone", 500.00, 20);
        InventoryItem inventoryItem3 = new InventoryItem(department, "Tablet","Tablet Computer", 300.00, 15);
        InventoryItem inventoryItem4 = new InventoryItem(department, "Monitor","Computer Monitor", 200.00, 5);

        store.addDepartment(department);
        store.addDepartment(department2);
        store.addDepartment(department3);
        store.addEmployee(employee);
        store.addEmployee(employee2);
        store.addInventoryItem(inventoryItem);
        store.addInventoryItem(inventoryItem2);
        store.addInventoryItem(inventoryItem3);
        store.addInventoryItem(inventoryItem4);

        System.out.println(store.getEmployees());;


    }

}
