package com.buymore.buymore.schedule;
///  For schedules I will need to think of a way to link thew // shifts to the employees and the store
// When making a schedule, I will need to know the store and the employees that are available for that schedule
// I will also need to know the date of the schedule, so I can link it to the shifts
// Maybe will create a randomizer to create the shifts for the employees then make schedule based on that
// create shifts at random times then assign random employees that are in the system to those shifts
// When shifts are created, they will be linked to the schedule by date of schedule, shifts that fall within 7 days will be added to that schedule

import com.buymore.buymore.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleId;

    private LocalDateTime startDateOfSchedule = LocalDateTime.now();

    @OneToMany()
    private List<Shift> listOfShifts = new ArrayList<>();

    public Schedule(long scheduleId, LocalDateTime startDateOfSchedule) {
        this.scheduleId = scheduleId;
        this.startDateOfSchedule = startDateOfSchedule;
        this.listOfShifts = new ArrayList<>();
    }

    public Schedule(LocalDateTime startDateOfSchedule) {
        this.startDateOfSchedule = startDateOfSchedule;
        this.listOfShifts = new ArrayList<>();

    }

    public Schedule() {
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<Shift> getListOfShifts() {
        return listOfShifts;
    }

    public void setListOfShifts(List<Shift> listOfShifts) {
        this.listOfShifts = listOfShifts;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "listOfShifts=" + listOfShifts +
                '}';
    }
}
