package com.studentinformationsystem.registrarservice.dto.instructor;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class InstructorDto {
    private DepartmentDto department;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;
    private boolean isAvailableForOtherDepartment;



    public InstructorDto() {

    }

    public InstructorDto(DepartmentDto department, String firstName, String lastName, String educationalEmail, DetailDto detail, boolean isAvailableForOtherDepartment) {
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
        this.isAvailableForOtherDepartment = isAvailableForOtherDepartment;
    }

}
