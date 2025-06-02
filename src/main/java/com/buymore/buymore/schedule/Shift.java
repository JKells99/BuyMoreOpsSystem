package com.buymore.buymore.schedule;

import com.buymore.buymore.employee.Employee;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
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
   @OneToOne(fetch = FetchType.LAZY)
   private Employee employee;


    public Shift(long shiftId, LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        this.shiftId = shiftId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftId=" + shiftId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", employee=" + employee +
                '}';
    }


}
