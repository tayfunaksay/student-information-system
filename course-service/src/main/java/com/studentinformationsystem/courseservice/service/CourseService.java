package com.studentinformationsystem.courseservice.service;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CourseNamesDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;

import java.util.List;

public interface CourseService {
    CourseDto create(CreateCourseRequest request);

    void delete(String courseId);

    CourseDto update(UpdateCourseRequest request);

    List<CourseDto> getAll();

    CourseDto getById(String courseId);
    CourseNamesDto getNamesById(String courseId);
}
