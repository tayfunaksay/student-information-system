package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.CreateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.InstructorForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.UpdateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.InstructorForCourse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstructorForCourseConverter implements InstructorForCourseMapper{
    @Override
    public InstructorForCourseDto toInstructorForCourseDto(InstructorForCourse from) {
        return InstructorForCourseDto.builder()
                .courseName(from.getCourseId())
                .instructorName(from.getInstructorId())
                .build();
    }

    @Override
    public List<InstructorForCourseDto> toInstructorForCourseDtoList(List<InstructorForCourse> from) {
        return from.stream()
                .map(instructorForCourse -> toInstructorForCourseDto(instructorForCourse))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorForCourse toInstructorForCourse(CreateInstructorForCourseRequest request) {
        return InstructorForCourse.builder()
                .courseId(request.getCourseId())
                .instructorId(request.getInstructorId())
                .build();
    }

    @Override
    public InstructorForCourse toInstructorForCourse(UpdateInstructorForCourseRequest request) {
        return InstructorForCourse.builder()
                .id(request.getId())
                .courseId(request.getCourseId())
                .instructorId(request.getInstructorId())
                .build();
    }
}
