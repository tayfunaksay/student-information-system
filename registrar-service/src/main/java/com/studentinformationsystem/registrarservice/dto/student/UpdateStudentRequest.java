package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;

public class UpdateStudentRequest {
    private long studentNumber;
    private long departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private UpdateDetailRequest detail;
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

    public UpdateDetailRequest getDetail() {
        return detail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
