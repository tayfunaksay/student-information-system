package com.studentinformationsystem.courseschedulingservice.service.abstracts;

import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.CreateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.GradeForDepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.UpdateGradeForDepartmentRequest;

import java.util.List;

public interface GradeForDepartmentService {
    GradeForDepartmentDto create (CreateGradeForDepartmentRequest request);
    GradeForDepartmentDto update (UpdateGradeForDepartmentRequest request);
    void delete (String gradeForDepartmentId);
    List<GradeForDepartmentDto> getAll ();
    List<GradeForDepartmentDto> getAllGradeWithDepartmentId (String departmentId);
}
