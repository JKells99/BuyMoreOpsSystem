package com.buymore.buymore.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ShiftService shiftService;

    @PostMapping("/createSchedule")
    public ResponseEntity<?> createSchedule(Schedule schedule) {
        return ResponseEntity.ok(scheduleService.createSchedule(schedule));
    }

    @PostMapping("/createShift")
    public ResponseEntity<?> createShift(Shift shift) {
        return ResponseEntity.ok(shiftService.createShift(shift));
    }

    @PostMapping("/createShiftsForWeek")
    public ResponseEntity<?> createShiftsForWeek() {
        shiftService.createShiftsForWeek();
        return new ResponseEntity<>("Shifts for the week have been created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("getAllShifts")
    public ResponseEntity<Iterable<Shift>> getAllShifts(){
        return ResponseEntity.ok(shiftService.getAllShifts());
    }

    @PostMapping("/createScheduleBasedOnShiftsForWeek")
    public ResponseEntity<Schedule> createScheduleBasedOnShiftsForWeek() {
        Schedule schedule = scheduleService.createSchedulebasedOnShiftsForWeek();
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/assignScheduleToStore/{storeId}/{scheduleId}")
    public ResponseEntity<String> assignScheduleToStore(@PathVariable Long storeId, @PathVariable Long scheduleId) {
        try {
            scheduleService.assignScheduleToStore(storeId, scheduleId);
            return ResponseEntity.ok("Schedule assigned to store successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error assigning schedule to store: " + e.getMessage());
        }
    }


}
