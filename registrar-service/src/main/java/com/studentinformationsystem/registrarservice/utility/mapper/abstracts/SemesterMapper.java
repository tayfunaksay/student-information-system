package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.registrarservice.dto.semester.SemesterDto;
import com.studentinformationsystem.registrarservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.registrarservice.model.Semester;

import java.util.List;

public interface SemesterMapper {
    SemesterDto toSemesterDto(Semester from);

    List<SemesterDto> toSemesterDtoList(List<Semester> from);

    Semester toSemester(CreateSemesterRequest request);

    Semester toSemester(UpdateSemesterRequest request);
}
