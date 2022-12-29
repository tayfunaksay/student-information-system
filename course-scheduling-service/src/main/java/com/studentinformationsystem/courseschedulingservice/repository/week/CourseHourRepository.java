package com.studentinformationsystem.courseschedulingservice.repository.week;

import com.studentinformationsystem.courseschedulingservice.model.week.CourseHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseHourRepository extends JpaRepository<CourseHour,Long> {
}
