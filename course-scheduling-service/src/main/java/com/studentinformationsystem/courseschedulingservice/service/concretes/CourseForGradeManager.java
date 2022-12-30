package com.studentinformationsystem.courseschedulingservice.service.concretes;

import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CourseForGradeDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.CreateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseForGrade.UpdateCourseForGradeRequest;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.CourseForGradeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseForGradeManager implements CourseForGradeService {
    @Override
    public CourseForGradeDto create(CreateCourseForGradeRequest request) {
        return null;
    }

    @Override
    public CourseForGradeDto update(UpdateCourseForGradeRequest request) {
        return null;
    }

    @Override
    public void delete(String courseForGradeId) {

    }

    @Override
    public List<CourseForGradeDto> getAll() {
        return null;
    }

    @Override
    public List<CourseForGradeDto> getAllCourseWithGradeId(String gradeId) {
        return null;
    }
}
