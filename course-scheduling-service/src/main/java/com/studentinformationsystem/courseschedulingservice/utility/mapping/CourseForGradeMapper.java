package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CourseForGradeDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CreateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.UpdateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.model.CourseForGrade;

import java.util.List;

public interface CourseForGradeMapper {
    CourseForGradeDto toCourseForGradeDto (CourseForGrade from);
    List<CourseForGradeDto> toCourseForGradeDtoList (List<CourseForGrade> from);
    CourseForGrade toCourseForGrade (CreateCourseForGradeRequest request);
    CourseForGrade toCourseForGrade (UpdateCourseForGradeRequest request);
}
