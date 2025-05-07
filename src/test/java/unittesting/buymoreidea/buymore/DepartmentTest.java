package unittesting.buymoreidea.buymore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DepartmentTest {

    @Test
    public void testDepartmentCreation() {
        Department electronics = new Department("Electronics");

        Assertions.assertEquals("Electronics", electronics.getDepartmentName());
    }

    @Test
    public void testDepartmentSetter() {
        Department groceries = new Department("Household");
        groceries.setDepartmentName("Groceries");

        Assertions.assertEquals("Groceries", groceries.getDepartmentName());
    }

    @Test
    public void testDepartmentError() {
        Department groceries = new Department("Household");
        groceries.setDepartmentName("Groceries");

        Assertions.assertNotEquals("Household", groceries.getDepartmentName());
    }

    @Test
    public void testDepartmentNull() {
        Department groceries = new Department("Household");
        groceries.setDepartmentName(null);

        Assertions.assertNull(groceries.getDepartmentName());
    }

}
