package com.studentinformationsystem.courseschedulingservice.repository.week;

import com.studentinformationsystem.courseschedulingservice.model.week.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek,Long> {
    @Query("select d from DayOfWeek d where d.isAvailableForCourses = true")
    List<DayOfWeek> findAllAvailableDayForCourses();
    @Query("select d from DayOfWeek d where d.isAvailableForCourses = false")
    List<DayOfWeek> findAllNotAvailableDayForCourses();
}
