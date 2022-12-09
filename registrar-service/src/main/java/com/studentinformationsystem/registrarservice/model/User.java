package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name="users")
public class User  {

    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String firstPassword;
    private String educationalEmail;

    public User() {
    }

    public User(Long id, String firstPassword, String educationalEmail) {
        this.id = id;
        this.firstPassword = firstPassword;
        this.educationalEmail = educationalEmail;
    }


    public Long getId() {
        return id;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }
}
