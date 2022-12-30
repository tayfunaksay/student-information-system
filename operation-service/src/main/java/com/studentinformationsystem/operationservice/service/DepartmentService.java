package com.studentinformationsystem.operationservice.service;

import com.studentinformationsystem.operationservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.operationservice.dto.department.DepartmentDto;
import com.studentinformationsystem.operationservice.dto.department.UpdateDepartmentRequest;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(CreateDepartmentRequest request);

    void delete(String departmentId);

    DepartmentDto update(UpdateDepartmentRequest request);

    List<DepartmentDto> getAll();

    DepartmentDto getById(String departmentId);
}
