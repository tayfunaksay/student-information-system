package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private Detail detail;

    private long studentNumber;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private String emailAddress;


    public Student() {
    }

    public Student(String id, Department department, Detail detail, long studentNumber, String firstName, String lastName, String educationalEmail, String emailAddress) {
        this.id = id;
        this.department = department;
        this.detail = detail;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.emailAddress = emailAddress;
    }



    public String getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public Detail getDetail() {
        return detail;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber && Objects.equals(department, student.department) && Objects.equals(detail, student.detail) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(educationalEmail, student.educationalEmail) && Objects.equals(emailAddress, student.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, detail, studentNumber, firstName, lastName, educationalEmail, emailAddress);
    }

    @Override
    public String toString() {
        return "Student{" +
                "department=" + department +
                ", detail=" + detail +
                ", studentNumber=" + studentNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
