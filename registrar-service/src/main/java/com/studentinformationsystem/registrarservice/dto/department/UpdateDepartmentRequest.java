package com.studentinformationsystem.registrarservice.dto.department;

public class UpdateDepartmentRequest {
    private String id;
    private String facultyId;
    private String name;
    private String code;

    public String getId() {
        return id;
    }

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
