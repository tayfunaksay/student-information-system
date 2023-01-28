package com.studentinformationsystem.courseschedulingservice.repository;

import com.studentinformationsystem.courseschedulingservice.model.CourseHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseHourRepository extends JpaRepository<CourseHour,String> {
}
