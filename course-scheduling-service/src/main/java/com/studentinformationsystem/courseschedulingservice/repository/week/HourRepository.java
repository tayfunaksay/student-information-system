package com.studentinformationsystem.courseschedulingservice.repository.week;

import com.studentinformationsystem.courseschedulingservice.model.week.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourRepository extends JpaRepository<Hour,Long> {
    @Query("select h from Hour h where h.isAvailableForCourses = true")
    List<Hour> getAllAvailableHourForCourses ();
}
