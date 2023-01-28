package com.studentinformationsystem.courseschedulingservice.utility.mapping.course;

import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements CourseMapper {

    @Override
    public CourseDto toCourseDto(Course from, DepartmentDto departmentDto) {
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
                .semesterType(from.getSemesterType())
                .departmentName(departmentDto.getName())
                .isNeedProjectorAndComputer(from.isNeedProjectorAndComputer())
                .build();
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
                .semesterType(request.getSemesterType())
                .departmentId(request.getDepartmentId())
                .isNeedProjectorAndComputer(request.isNeedProjectorAndComputer())
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
                .semesterType(request.getSemesterType())
                .departmentId(request.getDepartmentId())
                .isNeedProjectorAndComputer(request.isNeedProjectorAndComputer())
                .build();
    }

}
