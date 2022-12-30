package com.studentinformationsystem.courseschedulingservice.service.abstracts;

import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CourseForGradeDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CreateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.UpdateCourseForGradeRequest;

import java.util.List;

public interface CourseForGradeService {
    CourseForGradeDto create (CreateCourseForGradeRequest request);
    CourseForGradeDto update (UpdateCourseForGradeRequest request);
    void delete (String courseForGradeId);
    List<CourseForGradeDto> getAll ();
    List<CourseForGradeDto> getAllCourseWithGradeId (String gradeId);
}
