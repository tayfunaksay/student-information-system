package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class StudentDto {
    private String firstName;
    private String lastName;
    private long studentNumber;
    private String educationalEmail;
    private String emailAddress;
    private DepartmentDto department;
    private DetailDto detail;

    public StudentDto() {
    }

    public StudentDto(long studentNumber, DepartmentDto department, String firstName, String lastName, String educationalEmail, DetailDto detail, String emailAddress) {
        this.studentNumber = studentNumber;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
        this.emailAddress = emailAddress;
    }


}
