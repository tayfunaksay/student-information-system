package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.registrarservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentManager implements DepartmentService{
    @Override
    public DepartmentDto create(CreateDepartmentRequest request) {
        return null;
    }

    @Override
    public DepartmentDto delete(String departmentId) {
        return null;
    }

    @Override
    public DepartmentDto update(UpdateDepartmentRequest request) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAll() {
        return null;
    }

    @Override
    public DepartmentDto getById(String departmentId) {
        return null;
    }
}
