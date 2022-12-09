package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.registrarservice.model.Department;

import java.util.List;

public interface DepartmentMapper {
    DepartmentDto toDepartmentDto(Department from);
    List<DepartmentDto> toDepartmentDtoList (List<Department> from);
    Department toDepartment(CreateDepartmentRequest request);
    Department toDepartment(UpdateDepartmentRequest request);
}
