package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private long studentNumber;
    private String educationalEmail;
    private String emailAddress;
    private DepartmentDto department;
    private DetailDto detail;

    public StudentDto() {
    }

    public StudentDto(String id, String firstName, String lastName, long studentNumber, String educationalEmail, String emailAddress, DepartmentDto department, DetailDto detail) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.educationalEmail = educationalEmail;
        this.emailAddress = emailAddress;
        this.department = department;
        this.detail = detail;
    }
}
