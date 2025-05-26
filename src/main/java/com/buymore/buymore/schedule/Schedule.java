package com.buymore.buymore.schedule;

import com.buymore.buymore.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleId;

    @OneToMany()
    private List<Shift> listOfShifts;

    public Schedule(long scheduleId) {
        this.scheduleId = scheduleId;
        this.listOfShifts = new ArrayList<>();
    }

    public Schedule() {
        this.listOfShifts = new ArrayList<>();

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
