package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.registrarservice.dto.student.StudentDto;
import com.studentinformationsystem.registrarservice.dto.student.UpdateStudentRequest;

import java.util.List;

public interface StudentService {
    StudentDto create (CreateStudentRequest request);
    StudentDto delete (String studentId);
    StudentDto update (UpdateStudentRequest request);
    List<StudentDto> getAll();
    StudentDto getById(String studentId);
}
