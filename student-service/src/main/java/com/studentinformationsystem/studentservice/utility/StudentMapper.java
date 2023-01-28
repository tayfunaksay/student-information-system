package com.studentinformationsystem.studentservice.utility;

import com.studentinformationsystem.studentservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.studentservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.student.StudentDto;
import com.studentinformationsystem.studentservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.model.Student;

public interface StudentMapper {
    StudentDto toStudentDto(Student from, DepartmentDto departmentDto);

    Student toStudent(CreateStudentRequest request,String detailId,String educationalEmail);

    Student toStudent(UpdateStudentRequest request);
}
