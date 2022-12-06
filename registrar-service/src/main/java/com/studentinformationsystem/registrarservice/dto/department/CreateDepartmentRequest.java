package com.studentinformationsystem.registrarservice.dto.department;

public class CreateDepartmentRequest {
    private long facultyId;
    private String name;
    private String code;


    public long getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
