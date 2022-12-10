package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.course.CourseDto;
import com.studentinformationsystem.registrarservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.registrarservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.registrarservice.model.Course;
import com.studentinformationsystem.registrarservice.model.Department;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.CourseMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DepartmentMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter implements CourseMapper {
    private final DepartmentMapper departmentMapper;

    public CourseConverter(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public CourseDto toCourseDto(Course from) {
        return CourseDto.builder()
                .id(from.getId())
                .originalName(from.getOriginalName())
                .turkishName(from.getTurkishName())
                .code(from.getCode())
                .courseCredit(from.getCourseCredit())
                .courseAKTS(from.getCourseAKTS())
                .departmentDto(departmentMapper.toDepartmentDto(from.getDepartment()))
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
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
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
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .build();
    }
}
