package com.studentinformationsystem.registrarservice.dto.user;

public class CreateUserRequest {

    private String roleId;
    private String password;
    private String educationalEmail;
    private String staffIdWhoSendRequest;

    public String getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public String getStaffIdWhoSendRequest() {
        return staffIdWhoSendRequest;
    }
}
