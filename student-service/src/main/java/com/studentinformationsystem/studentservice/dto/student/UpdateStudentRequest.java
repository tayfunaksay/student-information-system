package com.studentinformationsystem.studentservice.dto.student;

import com.studentinformationsystem.studentservice.model.ClassLevel;
import lombok.Builder;

import java.util.Objects;

@Builder
public class UpdateStudentRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String emailAddress;
    private String departmentId;
    private ClassLevel classLevel;
    private String nationalIdentity;
    private String gender;
    private boolean isGraduated;

    public UpdateStudentRequest() {
    }

    public UpdateStudentRequest(String id, String firstName, String lastName, String studentNumber, String emailAddress, String departmentId, ClassLevel classLevel, String nationalIdentity, String gender, boolean isGraduated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.emailAddress = emailAddress;
        this.departmentId = departmentId;
        this.classLevel = classLevel;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.isGraduated = isGraduated;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateStudentRequest that = (UpdateStudentRequest) o;
        return isGraduated == that.isGraduated && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(studentNumber, that.studentNumber) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(departmentId, that.departmentId) && classLevel == that.classLevel && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentNumber, emailAddress, departmentId, classLevel, nationalIdentity, gender, isGraduated);
    }

    @Override
    public String toString() {
        return "UpdateStudentRequest{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", classLevel=" + classLevel +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
