package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CourseForGradeDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CreateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.UpdateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.model.CourseForGrade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseForGradeConverter implements CourseForGradeMapper{
    @Override
    public CourseForGradeDto toCourseForGradeDto(CourseForGrade from) {
        return CourseForGradeDto.builder()
                .courseName(from.getCourseId())
                .gradeName(from.getGradeId())
                .build();
    }

    @Override
    public List<CourseForGradeDto> toCourseForGradeDtoList(List<CourseForGrade> from) {
        return from.stream()
                .map(courseForGrade -> toCourseForGradeDto(courseForGrade))
                .collect(Collectors.toList());
    }

    @Override
    public CourseForGrade toCourseForGrade(CreateCourseForGradeRequest request) {
        return CourseForGrade.builder()
                .courseId(request.getCourseId())
                .gradeId(request.getGradeId())
                .build();
    }

    @Override
    public CourseForGrade toCourseForGrade(UpdateCourseForGradeRequest request) {
        return CourseForGrade.builder()
                .id(request.getId())
                .courseId(request.getCourseId())
                .gradeId(request.getGradeId())
                .build();
    }
}
