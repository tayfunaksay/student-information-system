package com.studentinformationsystem.registrarservice.dto.user;

public class CreateUserRequest {

    private long roleId;
    private String password;
    private String educationalEmail;

    public long getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }
}
