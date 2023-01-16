package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.dto.semester.SemesterDto;
import com.studentinformationsystem.courseschedulingservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.model.Semester;

import java.util.List;

public interface SemesterMapper {
    SemesterDto toSemesterDto(Semester from);

    List<SemesterDto> toSemesterDtoList(List<Semester> from);

    Semester toSemester(CreateSemesterRequest request);

    Semester toSemester(UpdateSemesterRequest request);
}
