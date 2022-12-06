package com.studentinformationsystem.registrarservice.dto.instructor;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;

public class CreateInstructorRequest {
    private String departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private CreateDetailRequest detail;
    private boolean isAvailableForOtherDepartment;

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

    public boolean isAvailableForOtherDepartment() {
        return isAvailableForOtherDepartment;
    }
}
