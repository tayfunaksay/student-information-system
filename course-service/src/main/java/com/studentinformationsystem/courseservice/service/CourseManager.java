package com.studentinformationsystem.courseservice.service;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseservice.exception.CourseNotFoundException;
import com.studentinformationsystem.courseservice.repository.CourseRepository;
import com.studentinformationsystem.courseservice.utility.CourseMapper;
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
        if (courseRepository.existsById(request.getId())){
            return courseMapper.toCourseDto(courseRepository.save(courseMapper.toCourse(request)));
        }else {
            throw new CourseNotFoundException("Course could not found by id: "+request.getId());
        }
    }

    @Override
    public List<CourseDto> getAll() {
        return courseMapper.toCourseDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDto getById(String courseId) {
        return courseMapper.toCourseDto(courseRepository.findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException("Course could not found by id: "+courseId)));
    }
}
