package com.studentinformationsystem.operationservice.model;

public enum UserRole {
    STUDENT(1),
    INSTRUCTOR(2),
    ADMIN(3);

    public final int userRoleValue;

    UserRole(int userRoleValue) {
        this.userRoleValue = userRoleValue;
    }

    public int getUserRoleValue() {
        return userRoleValue;
    }
}
