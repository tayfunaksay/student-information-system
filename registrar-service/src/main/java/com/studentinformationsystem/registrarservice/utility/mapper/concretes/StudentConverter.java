package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.registrarservice.dto.student.StudentDto;
import com.studentinformationsystem.registrarservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.registrarservice.model.Department;
import com.studentinformationsystem.registrarservice.model.Student;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DepartmentMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DetailMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter implements StudentMapper {
    private final DepartmentMapper departmentMapper;
    private final DetailMapper detailMapper;

    public StudentConverter(DepartmentMapper departmentMapper, DetailMapper detailMapper) {
        this.departmentMapper = departmentMapper;
        this.detailMapper = detailMapper;
    }

    @Override
    public StudentDto toStudentDto(Student from) {
        return StudentDto.builder()
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .studentNumber(from.getStudentNumber())
                .educationalEmail(from.getEducationalEmail())
                .emailAddress(from.getEmailAddress())
                .department(departmentMapper.toDepartmentDto(from.getDepartment()))
                .detail(detailMapper.toDetailDto(from.getDetail()))
                .build();
    }

    @Override
    public List<StudentDto> toStudentDtoList(List<Student> from) {
        return from.stream()
                .map(student -> toStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public Student toStudent(CreateStudentRequest request) {
        return Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .studentNumber(request.getStudentNumber())
                .educationalEmail(request.getEducationalEmail())
                .emailAddress(request.getEmailAddress())
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .detail(detailMapper.toDetail(request.getDetail()))
                .build();
    }

    @Override
    public Student toStudent(UpdateStudentRequest request) {
        return Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .studentNumber(request.getStudentNumber())
                .educationalEmail(request.getEducationalEmail())
                .emailAddress(request.getEmailAddress())
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .detail(detailMapper.toDetail(request.getDetail()))
                .build();
    }
}
