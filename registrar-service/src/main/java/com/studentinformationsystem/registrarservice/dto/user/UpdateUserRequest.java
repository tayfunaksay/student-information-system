package com.studentinformationsystem.registrarservice.dto.user;

public class UpdateUserRequest {
    private String password;
    private String educationalEmail;
    private long staffIdWhoSendRequest;

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
