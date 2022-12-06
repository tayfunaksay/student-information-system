package com.studentinformationsystem.registrarservice.dto.staff;

import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;

public class UpdateStaffRequest {

    private String departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private UpdateDetailRequest detail;

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
}
