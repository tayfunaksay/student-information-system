package com.studentinformationsystem.courseschedulingservice.repository;

import com.studentinformationsystem.courseschedulingservice.model.CourseHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseHourRepository extends JpaRepository<CourseHour,Long> {
    @Query("select c from CourseHour c where c.isAvailable = 1")
    List<CourseHour> findAllAvailableCourseHour ();
}
