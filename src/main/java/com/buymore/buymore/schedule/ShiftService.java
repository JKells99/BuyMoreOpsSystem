package com.buymore.buymore.schedule;

import com.buymore.buymore.employee.Employee;
import com.buymore.buymore.employee.EmployeeRestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ShiftService {
    @Autowired
    private ShiftRestRepository shiftRestRepository;

    @Autowired
    private EmployeeRestRepo employeeRestRepo;

    /**
     * Creates a new shift in the system.
     *
     * @param shift The Shift object to be created.
     * @return The created Shift object.
     */
    public Shift createShift(Shift shift) {

       return shiftRestRepository.save(shift);

    }

    public LocalDateTime getRandomDateBetweenNowANdNextWeek() {
       LocalDateTime now = LocalDateTime.now();
       LocalDateTime nextWeek = now.plusWeeks(1);
         long randomMillis = (long) (Math.random() * (nextWeek.toInstant(java.time.ZoneOffset.UTC).toEpochMilli() - now.toInstant(java.time.ZoneOffset.UTC).toEpochMilli())) + now.toInstant(java.time.ZoneOffset.UTC).toEpochMilli();
         return LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(randomMillis), java.time.ZoneOffset.UTC);

    }

    public void createShiftsForWeek() {
        Iterable<Employee> employees = employeeRestRepo.findAll();

        for (Employee employee : employees) {
            int shiftCount = (int) (Math.random() * 5) + 1; // 1 to 5 shifts

            for (int i = 0; i < shiftCount; i++) {
                LocalDateTime start = getRandomDateBetweenNowAndNextWeek();
                Shift shift = new Shift();
                shift.getEmployese().add(employee);
                shift.setStartTime(start);
                shift.setEndTime(start.plusHours(8)); // 8-hour shift
                shiftRestRepository.save(shift);
            }
        }
    }

    private LocalDateTime getRandomDateBetweenNowAndNextWeek() {
        ZoneOffset offset = ZoneOffset.ofHoursMinutes(-3, -30); // Newfoundland
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusDays(7);

        long start = now.toEpochSecond(offset);
        long end = nextWeek.toEpochSecond(offset);

        long randomEpoch = ThreadLocalRandom.current().nextLong(start, end);
        return LocalDateTime.ofEpochSecond(randomEpoch, 0, offset);
    }


    public Iterable<Shift> getAllShifts() {
        return shiftRestRepository.findAll();
    }






}
