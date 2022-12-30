package com.studentinformationsystem.operationservice.utility.mapper.abstracts;

import com.studentinformationsystem.operationservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.operationservice.dto.semester.SemesterDto;
import com.studentinformationsystem.operationservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.operationservice.model.Semester;

import java.util.List;

public interface SemesterMapper {
    SemesterDto toSemesterDto(Semester from);

    List<SemesterDto> toSemesterDtoList(List<Semester> from);

    Semester toSemester(CreateSemesterRequest request);

    Semester toSemester(UpdateSemesterRequest request);
}
