package com.buymore.buymore.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRestRepository extends JpaRepository<Schedule, Long> {
}
