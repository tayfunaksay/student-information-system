package com.studentinformationsystem.courseschedulingservice.service.courseHour;

import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.UpdateCourseHourRequest;

import java.util.List;

public interface CourseHourService {
    CourseHourDto create(CreateCourseHourRequest request);

    CourseHourDto update(UpdateCourseHourRequest request);

    void delete(String courseHourId);

    List<CourseHourDto> getAll();
}
