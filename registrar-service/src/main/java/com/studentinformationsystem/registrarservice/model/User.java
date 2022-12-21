package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String firstPassword;
    private String educationalEmail;

    public User() {
    }

    public User(String id, String firstPassword, String educationalEmail) {
        this.id = id;
        this.firstPassword = firstPassword;
        this.educationalEmail = educationalEmail;
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
}
