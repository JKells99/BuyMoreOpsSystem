package unittesting.buymoreidea.buymore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleTest {
    Schedule schedule;
    Employee employee;
    Employee employee2;

    @BeforeEach
    void setUp() {
        employee = new Employee("alice123", "password1", "Alice", "Smith", "123-456-7890", "alice@example.com", "123 Main St", "Barista", 18.50);
        employee2 = new Employee("bob123", "password2", "Bob", "Johnson", "234-567-8901","j@b.com", "456 Oak Ave", "Manager", 25.00);
        schedule = new Schedule();
        schedule.addShift(new Shift(LocalDateTime .now(), LocalDateTime.now().plusHours(8), employee));
        schedule.addShift(new Shift(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(8), employee2));
        schedule.addShift(new Shift(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(8), employee));

    }

    @AfterEach
    void tearDown() {
        schedule = null;
        employee = null;
        employee2 = null;
    }


    @Test
    void testAddShift() {
        Shift shift = new Shift(LocalDateTime.now(), LocalDateTime.now().plusHours(8), employee);
        System.out.println(shift);
        schedule.addShift(shift);
        Assertions.assertTrue(schedule.getListOfShifts().contains(shift));
    }

    @Test
    void testRemoveShift() {
        Shift shift = new Shift(LocalDateTime.now(), LocalDateTime.now().plusHours(8), employee);
        schedule.addShift(shift);
        schedule.removeShift(shift);
        Assertions.assertFalse(schedule.getListOfShifts().contains(shift));
    }

    @Test
    void testShiftHasCorrectData() {
        Assertions.assertNotNull(schedule.getListOfShifts());
        schedule.getListOfShifts().forEach(shift -> {
            Assertions.assertNotNull(shift.getEmployee());
            Assertions.assertNotNull(shift.getStartTime());
            Assertions.assertNotNull(shift.getEndTime());
            Assertions.assertNotNull(shift.getDurationOfShift());
        });


    }

    @Test
    void testGetShiftsForCurrentDay() {
        List<Shift> returedShifts = schedule.getShiftsForCurrentDay();
        Assertions.assertNotNull(returedShifts);

    }
    @Test
    void testGetShiftsForWeek() {
        schedule.getShiftsForWeek();
        Assertions.assertNotNull(schedule.getListOfShifts());
    }


}
