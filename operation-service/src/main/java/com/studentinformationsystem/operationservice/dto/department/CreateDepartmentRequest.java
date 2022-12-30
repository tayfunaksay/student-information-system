package com.studentinformationsystem.operationservice.dto.department;

public class CreateDepartmentRequest {
    private String facultyId;
    private String name;
    private String code;


    public String getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
