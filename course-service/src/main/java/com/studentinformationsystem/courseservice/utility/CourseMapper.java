package com.studentinformationsystem.courseservice.utility;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CourseNamesDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseservice.model.Course;

import java.util.List;

public interface CourseMapper {
    CourseDto toCourseDto(Course from);

    List<CourseDto> toCourseDtoList(List<Course> from);

    Course toCourse(CreateCourseRequest request);

    Course toCourse(UpdateCourseRequest request);
    CourseNamesDto toCourseNamesDto (Course from);
}
