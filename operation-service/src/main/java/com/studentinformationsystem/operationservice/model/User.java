package com.studentinformationsystem.operationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import java.util.Objects;

@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String firstPassword;
    private String educationalEmail;
    private UserRole userRole;
    private boolean isSentToAuthServer;
    public User() {
    }

    public User(String id, String firstPassword, String educationalEmail, UserRole userRole, boolean isSentToAuthServer) {
        this.id = id;
        this.firstPassword = firstPassword;
        this.educationalEmail = educationalEmail;
        this.userRole = userRole;
        this.isSentToAuthServer = isSentToAuthServer;
    }

    public String getId() {
        return id;
    }

    public String getFirstPassword() {
        return firstPassword;
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
        User user = (User) o;
        return isSentToAuthServer == user.isSentToAuthServer && Objects.equals(id, user.id) && Objects.equals(firstPassword, user.firstPassword) && Objects.equals(educationalEmail, user.educationalEmail) && userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstPassword, educationalEmail, userRole, isSentToAuthServer);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstPassword='" + firstPassword + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", userRole=" + userRole +
                ", isSentToAuthServer=" + isSentToAuthServer +
                '}';
    }
}
