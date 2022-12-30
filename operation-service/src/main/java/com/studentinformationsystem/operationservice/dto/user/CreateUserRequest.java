package com.studentinformationsystem.operationservice.dto.user;

import com.studentinformationsystem.operationservice.model.UserRole;
import lombok.Builder;

@Builder
public class CreateUserRequest {
    private String id;
    private String firstName;
    private String lastName;
    private UserRole userRole;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String id, String firstName, String lastName, UserRole userRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

    public String getId() {
        return id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
