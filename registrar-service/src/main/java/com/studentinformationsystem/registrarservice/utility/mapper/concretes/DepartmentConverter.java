package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.registrarservice.model.Department;
import com.studentinformationsystem.registrarservice.model.Faculty;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DepartmentMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.FacultyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter implements DepartmentMapper {
    private final FacultyMapper facultyMapper;

    public DepartmentConverter(FacultyMapper facultyMapper) {
        this.facultyMapper = facultyMapper;
    }

    @Override
    public DepartmentDto toDepartmentDto(Department from) {
        return DepartmentDto.builder()
                .id(from.getId())
                .name(from.getName())
                .code(from.getCode())
                .facultyDto(facultyMapper.toFacultyDto(from.getFaculty()))
                .build();
    }

    @Override
    public List<DepartmentDto> toDepartmentDtoList(List<Department> from) {
        return from.stream()
                .map(department -> toDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public Department toDepartment(CreateDepartmentRequest request) {
        return Department.builder()
                .name(request.getName())
                .code(request.getCode())
                .faculty(Faculty.builder()
                        .id(request.getFacultyId())
                        .build())
                .build();
    }

    @Override
    public Department toDepartment(UpdateDepartmentRequest request) {
        return Department.builder()
                .id(request.getId())
                .name(request.getName())
                .code(request.getCode())
                .faculty(Faculty.builder()
                        .id(request.getFacultyId())
                        .build())
                .build();
    }
}
