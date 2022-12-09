package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.registrarservice.dto.student.StudentDto;
import com.studentinformationsystem.registrarservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.registrarservice.model.Student;

import java.util.List;

public interface StudentMapper {
    StudentDto toStudentDto(Student from);
    List<StudentDto> toStudentDtoList (List<Student> from);
    Student toStudent(CreateStudentRequest request);
    Student toStudent(UpdateStudentRequest request);
}
