package com.studentinformationsystem.courseschedulingservice.repository.week;

import com.studentinformationsystem.courseschedulingservice.model.week.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {
}
