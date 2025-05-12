package unittesting.buymoreidea.buymore;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {
    List<Shift> listOfShifts;

    public Schedule() {
        this.listOfShifts = new ArrayList<>();
    }

    public List<Shift> getListOfShifts() {
        return listOfShifts;
    }

    public void setListOfShifts(List<Shift> listOfShifts) {
        this.listOfShifts = listOfShifts;
    }
    public void addShift(Shift shift) {
        this.listOfShifts.add(shift);
    }
    public void removeShift(Shift shift) {
        this.listOfShifts.remove(shift);
    }
    public List<Shift> getShiftsForCurrentDay() {
        LocalDate today = LocalDate.now();
        List<Shift> todaysShifts = new ArrayList<>();

        for (Shift shift : listOfShifts) {
            if (shift.getStartTime().toLocalDate().equals(today)) {
                todaysShifts.add(shift);
                System.out.println(shift);
            }
        }

        return todaysShifts;
    }

    public void getShiftsForWeek() {
        LocalDate currentDate = LocalDate.now();
        for (Shift shift : listOfShifts) {
            if (shift.getStartTime().isAfter(currentDate.minusDays(7).atStartOfDay())) {
                System.out.println(shift);
            }
        }
    }

    public void printAllShiftFormatted() {
        for (Shift shift : listOfShifts) {
            Employee emp = shift.getEmployee();

            System.out.println("Shift ID: " + shift.getShiftId());
            System.out.println("Start Time: " + shift.getStartTime());
            System.out.println("End Time: " + shift.getEndTime());
            System.out.println("Employee: " + (emp == null ? "Not Assigned" : emp.getEmployeeFirstName()));
            System.out.println("Duration: " + shift.getDurationOfShift().toHours() + " hours");
            System.out.println("-----------------------------");
        }
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "listOfShifts=" + listOfShifts +
                '}';
    }
}
