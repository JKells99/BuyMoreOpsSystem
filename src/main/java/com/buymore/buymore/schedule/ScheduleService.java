package com.buymore.buymore.schedule;

import com.buymore.buymore.employee.Employee;
import com.buymore.buymore.employee.EmployeeRestRepo;
import com.buymore.buymore.store.Store;
import com.buymore.buymore.store.StoreRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRestRepository scheduleRestRepository;

    @Autowired
    private ShiftRestRepository shiftRestRepository;
    @Autowired
    private StoreRestRepository storeRestRepository;
    @Autowired
    private EmployeeRestRepo employeeRestRepo;


    /**
     * @return
     */
    public Schedule createSchedulebasedOnShiftsForWeek() {
        Iterable<Shift> shifts = shiftRestRepository.findAll();
        Schedule schedule = new Schedule();
        for (Shift shift : shifts) {
            if(shift.getStartTime().isBefore(LocalDateTime.now().plusDays(6)) && shift.getStartTime().isAfter(LocalDateTime.now())) {
                schedule.getListOfShifts().add(shift);
            }
        }
        return scheduleRestRepository.save(schedule) ;
    }

    public Schedule createSchedule(Schedule schedule) {
        try {
            return scheduleRestRepository.save(schedule);
        } catch (Exception e) {
            throw new RuntimeException("Error creating schedule: " + e.getMessage());
        }
    }

    public void assignScheduleToStore(Long storeId,Long scheduleId) {
        Optional<Store> store = storeRestRepository.findById(storeId);
        Optional<Schedule> schedule = scheduleRestRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            if (store.isPresent()) {
                Schedule existingSchedule = schedule.get();
                Store existingStore = store.get();
                existingStore.getSchedules().add(existingSchedule);
                storeRestRepository.save(existingStore);


            } else {
                throw new RuntimeException("Store not found with id: " + storeId);
            }
        } else {
            throw new RuntimeException("Schedule not found with id: " + scheduleId);
        }

    }
}
