package com.studentinformationsystem.courseschedulingservice.service.abstracts.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.UpdateCourseHourRequest;

import java.util.List;

public interface CourseHourService {
    CourseHourDto create (CreateCourseHourRequest request);
    CourseHourDto update (UpdateCourseHourRequest request);
    void delete (Long courseHourId);
    List<CourseHourDto> getAll ();
    List<CourseHourDto> getAllAvailableCourseHour ();
}
