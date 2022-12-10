package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;

public class UpdateStudentRequest {
    private String id;
    private long studentNumber;
    private String departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private UpdateDetailRequest detail;
    private String emailAddress;

    public String getId() {
        return id;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public String getDepartmentId() {
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
