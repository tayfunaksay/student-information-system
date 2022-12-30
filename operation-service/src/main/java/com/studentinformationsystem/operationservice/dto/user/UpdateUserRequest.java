package com.studentinformationsystem.operationservice.dto.user;

import com.studentinformationsystem.operationservice.model.UserRole;

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
