package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.department.UpdateDepartmentRequest;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create (CreateDepartmentRequest request);
    DepartmentDto delete (long departmentId);
    DepartmentDto update (UpdateDepartmentRequest request);
    List<DepartmentDto> getAll();
    DepartmentDto getById(long departmentId);
}