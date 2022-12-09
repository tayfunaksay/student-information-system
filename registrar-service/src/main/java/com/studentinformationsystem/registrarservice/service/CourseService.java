package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.course.CourseDto;
import com.studentinformationsystem.registrarservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.registrarservice.dto.course.UpdateCourseRequest;

import java.util.List;

public interface CourseService {
    CourseDto create (CreateCourseRequest request);
    CourseDto delete (long courseId);
    CourseDto update (UpdateCourseRequest request);
    List<CourseDto> getAll();
    CourseDto getById(long courseId);
}