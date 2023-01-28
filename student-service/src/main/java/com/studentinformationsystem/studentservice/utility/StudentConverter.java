package com.studentinformationsystem.studentservice.utility;

import com.studentinformationsystem.studentservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.studentservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.student.StudentDto;
import com.studentinformationsystem.studentservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements StudentMapper {
    @Override
    public StudentDto toStudentDto(Student from, DepartmentDto departmentDto) {
        return StudentDto.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .studentNumber(from.getStudentNumber())
                .educationalEmail(from.getEducationalEmail())
                .emailAddress(from.getEmailAddress())
                .departmentName(departmentDto.getName())
                .classLevel(from.getClassLevel())
                .detailId(from.getDetailId())
                .nationalIdentity(from.getNationalIdentity())
                .gender(from.getGender())
                .isGraduated(from.isGraduated())
                .build();
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
