package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.course.CourseDto;
import com.studentinformationsystem.registrarservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.registrarservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.registrarservice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManager implements CourseService
{
    @Override
    public CourseDto create(CreateCourseRequest request) {
        return null;
    }

    @Override
    public CourseDto delete(long courseId) {
        return null;
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
    public CourseDto getById(long courseId) {
        return null;
    }
}
