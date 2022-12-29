package com.studentinformationsystem.courseservice.service;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManager implements CourseService {

    @Override
    public CourseDto create(CreateCourseRequest request) {
        return null;
    }

    @Override
    public void delete(String courseId) {

    }

    @Override
    public CourseDto update(UpdateCourseRequest request) {
        return null;
    }

    @Override
    public List<CourseDto> getAll() {
        return null;
    }

    @Override
    public CourseDto getById(String courseId) {
        return null;
    }
}
