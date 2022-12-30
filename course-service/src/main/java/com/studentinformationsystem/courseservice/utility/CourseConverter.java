package com.studentinformationsystem.courseservice.utility;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseservice.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter implements CourseMapper {

    @Override
    public CourseDto toCourseDto(Course from) {
        return CourseDto.builder()
                .id(from.getId())
                .originalName(from.getOriginalName())
                .turkishName(from.getTurkishName())
                .code(from.getCode())
                .courseCredit(from.getCourseCredit())
                .courseAKTS(from.getCourseAKTS())
                .theoreticalLessonHour(from.getTheoreticalLessonHour())
                .practicalLessonHour(from.getPracticalLessonHour())
                .courseType(from.getCourseType())
                .departmentId(from.getDepartmentId())
                .isNeedProjectorAndComputer(from.isNeedProjectorAndComputer())
                .isTherePreCourse(from.isTherePreCourse())
                .build();
    }

    @Override
    public List<CourseDto> toCourseDtoList(List<Course> from) {
        return from.stream()
                .map(course -> toCourseDto(course))
                .collect(Collectors.toList());
    }

    @Override
    public Course toCourse(CreateCourseRequest request) {
        return Course.builder()
                .originalName(request.getOriginalName())
                .turkishName(request.getTurkishName())
                .code(request.getCode())
                .courseCredit(request.getCourseCredit())
                .courseAKTS(request.getCourseAKTS())
                .theoreticalLessonHour(request.getTheoreticalLessonHour())
                .practicalLessonHour(request.getPracticalLessonHour())
                .courseType(request.getCourseType())
                .departmentId(request.getDepartmentId())
                .isNeedProjectorAndComputer(request.isNeedProjectorAndComputer())
                .isTherePreCourse(request.isTherePreCourse())
                .build();
    }

    @Override
    public Course toCourse(UpdateCourseRequest request) {
        return Course.builder()
                .id(request.getId())
                .originalName(request.getOriginalName())
                .turkishName(request.getTurkishName())
                .code(request.getCode())
                .courseCredit(request.getCourseCredit())
                .courseAKTS(request.getCourseAKTS())
                .theoreticalLessonHour(request.getTheoreticalLessonHour())
                .practicalLessonHour(request.getPracticalLessonHour())
                .courseType(request.getCourseType())
                .departmentId(request.getDepartmentId())
                .isNeedProjectorAndComputer(request.isNeedProjectorAndComputer())
                .isTherePreCourse(request.isTherePreCourse())
                .build();
    }

}
