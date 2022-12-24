package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.registrarservice.dto.student.StudentDto;
import com.studentinformationsystem.registrarservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.registrarservice.exception.StudentNotFoundException;
import com.studentinformationsystem.registrarservice.repository.StudentRepository;
import com.studentinformationsystem.registrarservice.service.StudentService;
import com.studentinformationsystem.registrarservice.service.UserService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.StudentMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManager implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    public StudentManager(StudentRepository studentRepository, StudentMapper studentMapper, UserService userService, UserMapper userMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public StudentDto create(CreateStudentRequest request) {
        StudentDto createdStudent = studentMapper.toStudentDto(studentRepository.save(studentMapper.toStudent(request)));
        userService.create(userMapper.toCreateUserRequest(createdStudent));
        return createdStudent;
    }

    @Override
    public void delete(String studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentDto update(UpdateStudentRequest request) {
        if (studentRepository.findById(request.getId()).isEmpty()) {
            throw new StudentNotFoundException("Student could not found by id: " + request.getId());
        } else {
            return studentMapper.toStudentDto(studentRepository.save(studentMapper.toStudent(request)));
        }
    }

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toStudentDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto getById(String studentId) {
        return studentMapper.toStudentDto(studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student could not found by id: " + studentId)));
    }
}
