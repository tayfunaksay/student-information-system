package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name="users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;


    private long roleId;
    private String password;
    private String educationalEmail;



    public User() {
    }

    public User(Long id, long roleId, String password, String educationalEmail) {
        this.id = id;
        this.roleId = roleId;
        this.password = password;
        this.educationalEmail = educationalEmail;
    }


    public Long getId() {
        return id;
    }

    public long getRoleId() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }
}
