package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.course.CourseDto;
import com.studentinformationsystem.registrarservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.registrarservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.registrarservice.model.Course;

import java.util.List;

public interface CourseMapper {
    CourseDto toCourseDto(Course from);
    List<CourseDto> toCourseDtoList (List<Course> from);
    Course toCourse(CreateCourseRequest request);
    Course toCourse(UpdateCourseRequest request);
}
