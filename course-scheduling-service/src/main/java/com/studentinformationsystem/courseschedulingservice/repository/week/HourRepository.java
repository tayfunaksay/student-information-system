package com.studentinformationsystem.courseschedulingservice.repository.week;

import com.studentinformationsystem.courseschedulingservice.model.week.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourRepository extends JpaRepository<Hour,Long> {
}
