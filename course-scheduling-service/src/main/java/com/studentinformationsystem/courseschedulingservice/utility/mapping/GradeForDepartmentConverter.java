package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.CreateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.GradeForDepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.UpdateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.model.GradeForDepartment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradeForDepartmentConverter implements GradeForDepartmentMapper{
    @Override
    public GradeForDepartmentDto toGradeForDepartmentDto(GradeForDepartment from) {
        return GradeForDepartmentDto.builder()
                .departmentName(from.getDepartmentId())
                .gradeName(from.getGradeId())
                .build();
    }

    @Override
    public List<GradeForDepartmentDto> toGradeForDepartmentDtoList(List<GradeForDepartment> from) {
        return from.stream()
                .map(gradeForDepartment -> toGradeForDepartmentDto(gradeForDepartment))
                .collect(Collectors.toList());
    }

    @Override
    public GradeForDepartment toGradeForDepartment(CreateGradeForDepartmentRequest request) {
        return GradeForDepartment.builder()
                .departmentId(request.getDepartmentId())
                .gradeId(request.getGradeId())
                .build();
    }

    @Override
    public GradeForDepartment toGradeForDepartment(UpdateGradeForDepartmentRequest request) {
        return GradeForDepartment.builder()
                .id(request.getId())
                .departmentId(request.getDepartmentId())
                .gradeId(request.getGradeId())
                .build();
    }
}
