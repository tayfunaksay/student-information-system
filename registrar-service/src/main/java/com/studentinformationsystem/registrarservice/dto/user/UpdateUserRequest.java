package com.studentinformationsystem.registrarservice.dto.user;

import com.studentinformationsystem.registrarservice.model.UserRole;

public class UpdateUserRequest {
    private String id;

    private UserRole userRole;

    public String getId() {
        return id;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
