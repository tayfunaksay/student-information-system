package com.studentinformationsystem.registrarservice.dto.instructor;

import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;

public class UpdateInstructorRequest {
    private String id;
    private String departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private UpdateDetailRequest detail;
    private boolean isAvailableForOtherDepartment;

    public String getId() {
        return id;
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

    public boolean isAvailableForOtherDepartment() {
        return isAvailableForOtherDepartment;
    }

}
