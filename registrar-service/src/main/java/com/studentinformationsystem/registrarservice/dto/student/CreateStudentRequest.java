package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;

public class CreateStudentRequest {
    private long studentNumber;
    private long departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private CreateDetailRequest detail;
    private String emailAddress;

    public long getStudentNumber() {
        return studentNumber;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public CreateDetailRequest getDetail() {
        return detail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
