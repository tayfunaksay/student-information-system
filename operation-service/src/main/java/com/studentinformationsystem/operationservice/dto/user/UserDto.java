package com.studentinformationsystem.operationservice.dto.user;

import com.studentinformationsystem.operationservice.model.UserRole;
import lombok.Builder;

import java.util.Objects;

@Builder
public class UserDto {
    private String id;
    private String educationalEmail;
    private UserRole userRole;
    private boolean isSentToAuthServer;

    public UserDto() {
    }

    public UserDto(String id, String educationalEmail, UserRole userRole, boolean isSentToAuthServer) {
        this.id = id;
        this.educationalEmail = educationalEmail;
        this.userRole = userRole;
        this.isSentToAuthServer = isSentToAuthServer;
    }

    public String getId() {
        return id;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public boolean isSentToAuthServer() {
        return isSentToAuthServer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return isSentToAuthServer == userDto.isSentToAuthServer && Objects.equals(id, userDto.id) && Objects.equals(educationalEmail, userDto.educationalEmail) && userRole == userDto.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, educationalEmail, userRole, isSentToAuthServer);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", userRole=" + userRole +
                ", isSentToAuthServer=" + isSentToAuthServer +
                '}';
    }
}
