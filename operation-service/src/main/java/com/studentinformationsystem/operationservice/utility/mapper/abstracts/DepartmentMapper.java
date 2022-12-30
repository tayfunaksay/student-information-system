package com.studentinformationsystem.operationservice.utility.mapper.abstracts;

import com.studentinformationsystem.operationservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.operationservice.dto.department.DepartmentDto;
import com.studentinformationsystem.operationservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.operationservice.model.Department;

import java.util.List;

public interface DepartmentMapper {
    DepartmentDto toDepartmentDto(Department from);
    Department toDepartment(DepartmentDto fromDto);

    List<DepartmentDto> toDepartmentDtoList(List<Department> from);

    Department toDepartment(CreateDepartmentRequest request);

    Department toDepartment(UpdateDepartmentRequest request);
}
