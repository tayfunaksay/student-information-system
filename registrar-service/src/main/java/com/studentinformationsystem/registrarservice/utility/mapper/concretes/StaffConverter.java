package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.staff.CreateStaffRequest;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.staff.UpdateStaffRequest;
import com.studentinformationsystem.registrarservice.model.Department;
import com.studentinformationsystem.registrarservice.model.Staff;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DepartmentMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DetailMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.StaffMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffConverter implements StaffMapper {
    private final DepartmentMapper departmentMapper;
    private final DetailMapper detailMapper;

    public StaffConverter(DepartmentMapper departmentMapper, DetailMapper detailMapper) {
        this.departmentMapper = departmentMapper;
        this.detailMapper = detailMapper;
    }
    @Override
    public StaffDto toStaffDto(Staff from) {
        return StaffDto.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .educationalEmail(from.getEducationalEmail())
                .detail(detailMapper.toDetailDto(from.getDetail()))
                .department(departmentMapper.toDepartmentDto(from.getDepartment()))
                .build();
    }

    @Override
    public List<StaffDto> toStaffDtoList(List<Staff> from) {
        return from.stream()
                .map(staff -> toStaffDto(staff))
                .collect(Collectors.toList());
    }

    @Override
    public Staff toStaff(CreateStaffRequest request) {
        return Staff.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(request.getEducationalEmail())
                .detail(detailMapper.toDetail(request.getDetail()))
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .build();
    }

    @Override
    public Staff toStaff(UpdateStaffRequest request) {
        return Staff.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(request.getEducationalEmail())
                .detail(detailMapper.toDetail(request.getDetail()))
                .department(Department.builder()
                        .id(request.getDepartmentId())
                        .build())
                .build();
    }
}
