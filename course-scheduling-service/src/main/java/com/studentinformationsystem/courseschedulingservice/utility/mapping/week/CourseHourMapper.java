package com.studentinformationsystem.courseschedulingservice.utility.mapping.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.UpdateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.model.week.CourseHour;

import java.util.List;

public interface CourseHourMapper {
    CourseHourDto toCourseHourDto (CourseHour from);
    List<CourseHourDto> toCourseHourDtoList(List<CourseHour> from);
    CourseHour toCourseHour (CreateCourseHourRequest request);
    CourseHour toCourseHour (UpdateCourseHourRequest request);
}
