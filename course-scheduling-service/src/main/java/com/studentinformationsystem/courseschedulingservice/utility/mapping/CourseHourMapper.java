package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.UpdateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.model.CourseHour;

import java.util.List;

public interface CourseHourMapper {
    CourseHourDto toCourseHourDto (CourseHour from);
    List<CourseHourDto> toCourseHourDtoList(List<CourseHour> from);
    CourseHour toCourseHour (CreateCourseHourRequest request);
    CourseHour toCourseHour (UpdateCourseHourRequest request);
}
