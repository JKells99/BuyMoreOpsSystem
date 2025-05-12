package unittesting.buymoreidea.buymore;

import java.time.Duration;
import java.time.LocalDateTime;

public class Shift {
    // Each shoft will have a start time and end time
    // GOnna have a employee assigned to it
    // gonna have a total time
    int shiftId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    Employee employee;

    public Shift(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
    }

    public Shift() {
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
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
    public Duration getDurationOfShift() {
        if (startTime != null && endTime != null) {
            return Duration.between(startTime, endTime);
        } else {
            return Duration.ZERO;
        }
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
