package com.studentinformationsystem.studentservice.utility;

import com.studentinformationsystem.studentservice.dto.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.StudentDto;
import com.studentinformationsystem.studentservice.dto.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.model.Student;

import java.util.List;

public interface StudentMapper {
    StudentDto toStudentDto(Student from);

    List<StudentDto> toStudentDtoList(List<Student> from);

    Student toStudent(CreateStudentRequest request,String detailId,String educationalEmail);

    Student toStudent(UpdateStudentRequest request);
}
