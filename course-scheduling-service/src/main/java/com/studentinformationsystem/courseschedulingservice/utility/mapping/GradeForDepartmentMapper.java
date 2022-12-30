package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.CreateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.GradeForDepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment.UpdateGradeForDepartmentRequest;
import com.studentinformationsystem.courseschedulingservice.model.GradeForDepartment;

import java.util.List;

public interface GradeForDepartmentMapper {
    GradeForDepartmentDto toGradeForDepartmentDto (GradeForDepartment from);
    List<GradeForDepartmentDto> toGradeForDepartmentDtoList (List<GradeForDepartment> from);
    GradeForDepartment toGradeForDepartment (CreateGradeForDepartmentRequest request);
    GradeForDepartment toGradeForDepartment (UpdateGradeForDepartmentRequest request);
}
