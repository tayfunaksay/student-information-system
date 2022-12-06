package com.studentinformationsystem.registrarservice.dto.instructor;

import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class InstructorDto {
    private String departmentName;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;
    private boolean isAvailableForOtherDepartment;



    public InstructorDto() {

    }

    public InstructorDto(String departmentName, String firstName, String lastName, String educationalEmail, DetailDto detail, boolean isAvailableForOtherDepartment) {
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
        this.isAvailableForOtherDepartment = isAvailableForOtherDepartment;
    }

}
