package com.studentinformationsystem.courseservice.utility;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseservice.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseConverter implements CourseMapper {

    @Override
    public CourseDto toCourseDto(Course from) {
        return null;
    }

    @Override
    public List<CourseDto> toCourseDtoList(List<Course> from) {
        return null;
    }

    @Override
    public Course toCourse(CreateCourseRequest request) {
        return null;
    }

    @Override
    public Course toCourse(UpdateCourseRequest request) {
        return null;
    }
}
