package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.course.CourseDto;
import com.studentinformationsystem.registrarservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.registrarservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.registrarservice.exception.CourseNotFoundException;
import com.studentinformationsystem.registrarservice.repository.CourseRepository;
import com.studentinformationsystem.registrarservice.service.CourseService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManager implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseManager(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDto create(CreateCourseRequest request) {
        return courseMapper.toCourseDto(courseRepository.save(courseMapper.toCourse(request)));
    }

    @Override
    public void delete(String courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public CourseDto update(UpdateCourseRequest request) {
        if (courseRepository.findById(request.getId()).isEmpty()) {
            throw new CourseNotFoundException("Course could not found by id: " + request.getId());
        } else {
            return courseMapper.toCourseDto(courseRepository.save(courseMapper.toCourse(request)));
        }
    }

    @Override
    public List<CourseDto> getAll() {
        return courseMapper.toCourseDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDto getById(String courseId) {
        return courseMapper.toCourseDto(courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course could not found by id: " + courseId)));
    }
}
