package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.ClassroomForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.CreateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.UpdateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.ClassroomForCourse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassroomForCourseConverter implements ClassroomForCourseMapper {
    @Override
    public ClassroomForCourseDto toClassroomForCourseDto(ClassroomForCourse from) {
        return ClassroomForCourseDto.builder()
                .courseName(from.getCourseId())
                .classroomName(from.getClassroomId())
                .build();
    }

    @Override
    public List<ClassroomForCourseDto> toClassroomForCourseDtoList(List<ClassroomForCourse> from) {
        return from.stream()
                .map(classroomForCourse -> toClassroomForCourseDto(classroomForCourse))
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomForCourse toClassroomForCourse(CreateClassroomForCourseRequest request) {
        return ClassroomForCourse.builder()
                .courseId(request.getCourseId())
                .classroomId(request.getClassroomId())
                .build();
    }

    @Override
    public ClassroomForCourse toClassroomForCourse(UpdateClassroomForCourseRequest request) {
        return ClassroomForCourse.builder()
                .id(request.getId())
                .courseId(request.getCourseId())
                .classroomId(request.getClassroomId())
                .build();
    }
}
