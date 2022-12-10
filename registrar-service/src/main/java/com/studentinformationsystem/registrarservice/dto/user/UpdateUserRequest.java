package com.studentinformationsystem.registrarservice.dto.user;

public class UpdateUserRequest {
    private String id;
    private String password;
    private String educationalEmail;
    private String staffIdWhoSendRequest;

    public String getId() {
        return id;
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
