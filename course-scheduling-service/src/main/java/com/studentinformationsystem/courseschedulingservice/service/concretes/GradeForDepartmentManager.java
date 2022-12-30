package com.studentinformationsystem.courseschedulingservice.service.concretes;

import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.CreateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.GradeForDepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.UpdateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.GradeForDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeForDepartmentManager implements GradeForDepartmentService {
    @Override
    public GradeForDepartmentDto create(CreateGradeForDepartmentRequest request) {
        return null;
    }

    @Override
    public GradeForDepartmentDto update(UpdateGradeForDepartmentRequest request) {
        return null;
    }

    @Override
    public void delete(String gradeForDepartmentId) {

    }

    @Override
    public List<GradeForDepartmentDto> getAll() {
        return null;
    }

    @Override
    public List<GradeForDepartmentDto> getAllGradeWithDepartmentId(String departmentId) {
        return null;
    }
}
