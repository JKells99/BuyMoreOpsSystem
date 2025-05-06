package unittesting.buymoreidea;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unittesting.buymoreidea.buymore.Employee;

public class EmployeeTest {

    Employee employee;
    @BeforeEach
    public void setUp() {
        employee = new Employee("jkells","password","John", "Doe", "1234567890", "j@j.com", "123 Main St", "Manager", 50000);


    }
    @AfterEach
    public void tearDown() {
        employee = null;
    }
    @Test
    public void testEmployeeCreation() {
        Assertions.assertEquals("John", employee.getEmployeeFirstName());
        Assertions.assertEquals("Doe", employee.getEmployeeLastName());
        Assertions.assertEquals("1234567890", employee.getEmployeePhoneNumber());
        Assertions.assertNotEquals("j@k.com", employee.getEmployeeEmail());
        Assertions.assertNotNull(employee.getEmployeeAddress());

    }
    @Test
    public void testEmployeeSetter() {
        employee.setEmployeeFirstName("Jane");
        employee.setEmployeeLastName("Smith");
        employee.setEmployeePhoneNumber("0987654321");
        employee.setEmployeeEmail("j@s.com");
        employee.setEmployeeAddress("456 Elm St");
        Assertions.assertEquals("Jane", employee.getEmployeeFirstName());
        Assertions.assertEquals("Smith", employee.getEmployeeLastName());
        Assertions.assertEquals("0987654321", employee.getEmployeePhoneNumber());
        Assertions.assertNotEquals("Doe", employee.getEmployeeLastName());
        Assertions.assertNotEquals("1234567890", employee.getEmployeePhoneNumber());
        Assertions.assertNotNull(employee.getEmployeeAddress());


    }


    @Test
    void getEmployeeFirstName() {
        Assertions.assertEquals("John", employee.getEmployeeFirstName());
    }

    @Test
    void getEmployeeLastName() {
        Assertions.assertEquals("Doe", employee.getEmployeeLastName());
    }

    @Test
    void getEmployeePhoneNumber() {
        Assertions.assertEquals("1234567890", employee.getEmployeePhoneNumber());
    }

    @Test
    void getEmployeeEmail() {
        Assertions.assertEquals("j@j.com", employee.getEmployeeEmail());
    }

    @Test
    void getEmployeeAddress() {
        Assertions.assertEquals("123 Main St", employee.getEmployeeAddress());
    }

    @Test
    void getEmployeePosition() {
        Assertions.assertEquals("Manager", employee.getEmployeePosition());
    }

    @Test
    void getEmployeeSalary() {
        Assertions.assertEquals(50000, employee.getEmployeeSalary());
    }

    @Test
    void setEmployeeFirstName() {
        employee.setEmployeeFirstName("Jane");
        Assertions.assertEquals("Jane", employee.getEmployeeFirstName());
    }

    @Test
    void setEmployeeLastName() {
        employee.setEmployeeLastName("Smith");
        Assertions.assertEquals("Smith", employee.getEmployeeLastName());
    }

    @Test
    void setEmployeePhoneNumber() {
        employee.setEmployeePhoneNumber("0987654321");
        Assertions.assertEquals("0987654321", employee.getEmployeePhoneNumber());
    }

    @Test
    void setEmployeeEmail() {
        employee.setEmployeeEmail("j@jj.com");
        Assertions.assertEquals("j@jj.com", employee.getEmployeeEmail());
    }

    @Test
    void setEmployeeAddress() {
        employee.setEmployeeAddress("456 Elm St");
        Assertions.assertEquals("456 Elm St", employee.getEmployeeAddress());
    }

    @Test
    void setEmployeePosition() {
        employee.setEmployeePosition("Cashier");
        Assertions.assertEquals("Cashier", employee.getEmployeePosition());
    }

    @Test
    void setEmployeeSalary() {
        employee.setEmployeeSalary(60000);
        Assertions.assertEquals(60000, employee.getEmployeeSalary());
    }
}



