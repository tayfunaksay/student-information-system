package com.studentinformationsystem.studentservice.service;

import com.studentinformationsystem.studentservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.student.StudentDto;
import com.studentinformationsystem.studentservice.dto.student.UpdateStudentRequest;

import java.util.List;

public interface StudentService {
    StudentDto create(CreateStudentRequest request);

    void delete(String studentId);

    StudentDto update(UpdateStudentRequest request);

    List<StudentDto> getAllByDepartmentId(String departmentId);

    StudentDto getById(String studentId);
}
