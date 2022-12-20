package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.registrarservice.dto.student.StudentDto;
import com.studentinformationsystem.registrarservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.registrarservice.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManager implements StudentService {
    @Override
    public StudentDto create(CreateStudentRequest request) {
        return null;
    }

    @Override
    public void delete(String studentId) {

    }

    @Override
    public StudentDto update(UpdateStudentRequest request) {
        return null;
    }

    @Override
    public List<StudentDto> getAll() {
        return null;
    }

    @Override
    public StudentDto getById(String studentId) {
        return null;
    }
}
