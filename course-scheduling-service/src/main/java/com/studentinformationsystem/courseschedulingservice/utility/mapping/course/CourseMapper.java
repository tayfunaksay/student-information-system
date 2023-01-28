package com.studentinformationsystem.courseschedulingservice.utility.mapping.course;

import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.Course;

public interface CourseMapper {
    CourseDto toCourseDto(Course from, DepartmentDto departmentDto);

    Course toCourse(CreateCourseRequest request);

    Course toCourse(UpdateCourseRequest request);
}
