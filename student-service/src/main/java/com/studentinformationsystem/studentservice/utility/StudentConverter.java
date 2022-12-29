package com.studentinformationsystem.studentservice.utility;

import com.studentinformationsystem.studentservice.dto.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.StudentDto;
import com.studentinformationsystem.studentservice.dto.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter implements StudentMapper {
    @Override
    public StudentDto toStudentDto(Student from) {
        return StudentDto.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .studentNumber(from.getStudentNumber())
                .educationalEmail(from.getEducationalEmail())
                .emailAddress(from.getEmailAddress())
                .departmentId(from.getDepartmentId())
                .detailId(from.getDetailId())
                .nationalIdentity(from.getNationalIdentity())
                .gender(from.getGender())
                .isGraduated(from.isGraduated())
                .build();
    }

    @Override
    public List<StudentDto> toStudentDtoList(List<Student> from) {
        return from.stream()
                .map(student -> toStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public Student toStudent(CreateStudentRequest request,String detailId,String educationalEmail) {
        return Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .studentNumber(request.getStudentNumber())
                .educationalEmail(educationalEmail)
                .emailAddress(request.getEmailAddress())
                .departmentId(request.getDepartmentId())
                .detailId(detailId)
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .build();
    }

    @Override
    public Student toStudent(UpdateStudentRequest request) {
        return Student.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .studentNumber(request.getStudentNumber())
                .emailAddress(request.getEmailAddress())
                .departmentId(request.getDepartmentId())
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .build();
    }
}
