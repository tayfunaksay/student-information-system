package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Entity
@Table(name="users")
public class User  {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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
