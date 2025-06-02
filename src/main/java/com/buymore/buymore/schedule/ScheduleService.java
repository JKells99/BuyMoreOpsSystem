package com.buymore.buymore.schedule;

import com.buymore.buymore.employee.Employee;
import com.buymore.buymore.employee.EmployeeRestRepo;
import com.buymore.buymore.store.Store;
import com.buymore.buymore.store.StoreRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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


}
