package com.studentinformationsystem.registrarservice.dto.staff;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;

public class CreateStaffRequest {

    private String departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private CreateDetailRequest detail;

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

    public CreateDetailRequest getDetail() {
        return detail;
    }
}
