package com.studentinformationsystem.instructorservice.dto.instructor;


import java.util.Objects;

public class CreateInstructorRequest {

    private String firstName;
    private String lastName;
    private String educationalEmail;
    private String nationalIdentity;
    private String gender;
    private String departmentId;
    private boolean isAvailable;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateInstructorRequest that = (CreateInstructorRequest) o;
        return isAvailable == that.isAvailable && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender) && Objects.equals(educationalEmail, that.educationalEmail) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, nationalIdentity, gender, educationalEmail, departmentId, isAvailable);
    }

    @Override
    public String toString() {
        return "CreateInstructorRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
