package com.studentinformationsystem.instructorservice.dto.instructor;

import lombok.Builder;

import java.util.Objects;

@Builder
public class InstructorDto {
    private String id;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private String nationalIdentity;
    private String gender;
    private String departmentName;
    private String detailId;
    private boolean isAvailable;

    public InstructorDto() {

    }

    public InstructorDto(String id, String firstName, String lastName, String educationalEmail, String nationalIdentity, String gender, String departmentName, String detailId, boolean isAvailable) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.departmentName = departmentName;
        this.detailId = detailId;
        this.isAvailable = isAvailable;
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

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDetailId() {
        return detailId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDto that = (InstructorDto) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(educationalEmail, that.educationalEmail) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender) && Objects.equals(departmentName, that.departmentName) && Objects.equals(detailId, that.detailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, educationalEmail, nationalIdentity, gender, departmentName, detailId, isAvailable);
    }

    @Override
    public String toString() {
        return "InstructorDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", departmentId='" + departmentName + '\'' +
                ", detailId='" + detailId + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
