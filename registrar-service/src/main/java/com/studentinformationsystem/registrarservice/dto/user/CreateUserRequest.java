package com.studentinformationsystem.registrarservice.dto.user;

public class CreateUserRequest {

    private long roleId;
    private String password;
    private String educationalEmail;
    private long staffIdWhoSendRequest;

    public long getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public long getStaffIdWhoSendRequest() {
        return staffIdWhoSendRequest;
    }
}
