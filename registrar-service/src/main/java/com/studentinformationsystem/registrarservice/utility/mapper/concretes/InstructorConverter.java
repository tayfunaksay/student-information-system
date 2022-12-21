package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.registrarservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.registrarservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.registrarservice.model.Department;
import com.studentinformationsystem.registrarservice.model.Instructor;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DepartmentMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DetailMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.InstructorMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstructorConverter implements InstructorMapper {
    private final DepartmentMapper departmentMapper;
    private final DetailMapper detailMapper;

    public InstructorConverter(DepartmentMapper departmentMapper, DetailMapper detailMapper) {
        this.departmentMapper = departmentMapper;
        this.detailMapper = detailMapper;
    }

    @Override
    public InstructorDto toInstructorDto(Instructor from) {
        return InstructorDto.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .educationalEmail(from.getEducationalEmail())
                .isAvailableForOtherDepartment(from.isAvailableForOtherDepartment())
                .department(departmentMapper.toDepartmentDto(from.getDepartment()))
                .detail(detailMapper.toDetailDto(from.getDetail()))
                .build();
    }

    @Override
    public List<InstructorDto> toInstructorDtoList(List<Instructor> from) {
        return from.stream()
                .map(instructor -> toInstructorDto(instructor))
                .collect(Collectors.toList());
    }

    @Override
    public Instructor toInstructor(CreateInstructorRequest request) {
        return Instructor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(request.getEducationalEmail())
                .isAvailableForOtherDepartment(request.isAvailableForOtherDepartment())
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .detail(detailMapper.toDetail(request.getDetail()))
                .build();
    }

    @Override
    public Instructor toInstructor(UpdateInstructorRequest request) {
        return Instructor.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(request.getEducationalEmail())
                .isAvailableForOtherDepartment(request.isAvailableForOtherDepartment())
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .detail(detailMapper.toDetail(request.getDetail()))
                .build();
    }
}
