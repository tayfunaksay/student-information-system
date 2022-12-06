package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class StudentDto {
    private long studentNumber;
    private String departmentName;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;
    private String emailAddress;

    public StudentDto() {
    }

    public StudentDto(long studentNumber, String departmentName, String firstName, String lastName, String educationalEmail, DetailDto detail, String emailAddress) {
        this.studentNumber = studentNumber;
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
        this.emailAddress = emailAddress;
    }


}
