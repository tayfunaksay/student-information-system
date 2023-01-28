package com.studentinformationsystem.courseschedulingservice.service.course;

import com.studentinformationsystem.courseschedulingservice.dto.course.CourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.course.UpdateCourseRequest;

import java.util.List;

public interface CourseService {
    CourseDto create(CreateCourseRequest request);

    void delete(String courseId);

    CourseDto update(UpdateCourseRequest request);

    List<CourseDto> getAllByDepartmentId(String departmentId);

    CourseDto getById(String courseId);
}
