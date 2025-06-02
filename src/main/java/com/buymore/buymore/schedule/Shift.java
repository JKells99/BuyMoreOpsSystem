package com.buymore.buymore.schedule;

import com.buymore.buymore.employee.Employee;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shift {
    // Each shoft will have a start time and end time
    // GOnna have a employee assigned to it
    // gonna have a total time
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shiftId;
    private LocalDateTime startTime;
   private  LocalDateTime endTime;
   @ManyToMany
   private List<Employee> employese = new ArrayList<>();


    public Shift(long shiftId, LocalDateTime startTime, LocalDateTime endTime) {
        this.shiftId = shiftId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employese = new ArrayList<>();
    }

    public Shift() {
    }


    public long getShiftId() {
        return shiftId;
    }

    public void setShiftId(long shiftId) {
        this.shiftId = shiftId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Employee> getEmployese() {
        return employese;
    }

    public void setEmployese(List<Employee> employese) {
        this.employese = employese;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", employese=" + employese +
                '}';
    }
}
