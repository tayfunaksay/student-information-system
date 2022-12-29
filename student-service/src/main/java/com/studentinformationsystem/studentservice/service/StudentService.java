package com.studentinformationsystem.studentservice.service;

import com.studentinformationsystem.studentservice.dto.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.StudentDto;
import com.studentinformationsystem.studentservice.dto.UpdateStudentRequest;

import java.util.List;

public interface StudentService {
    StudentDto create(CreateStudentRequest request);

    void delete(String studentId);

    StudentDto update(UpdateStudentRequest request);

    List<StudentDto> getAll();

    StudentDto getById(String studentId);
}
