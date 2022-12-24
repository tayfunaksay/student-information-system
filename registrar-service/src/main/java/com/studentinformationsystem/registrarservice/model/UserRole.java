package com.studentinformationsystem.registrarservice.model;

public enum UserRole {
    STUDENT(1),
    INSTRUCTOR(2),
    STAFF(3),
    ADMIN(4);

    public final int userRoleValue;

    UserRole(int userRoleValue) {
        this.userRoleValue = userRoleValue;
    }

    public int getUserRoleValue() {
        return userRoleValue;
    }
}
