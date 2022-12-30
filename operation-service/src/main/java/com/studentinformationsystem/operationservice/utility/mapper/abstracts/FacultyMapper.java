package com.studentinformationsystem.operationservice.utility.mapper.abstracts;

import com.studentinformationsystem.operationservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.operationservice.model.Faculty;

import java.util.List;

public interface FacultyMapper {
    FacultyDto toFacultyDto(Faculty from);
    Faculty toFaculty (FacultyDto fromDto);

    List<FacultyDto> toFacultyDtoList(List<Faculty> from);

    Faculty toFaculty(CreateFacultyRequest request);

    Faculty toFaculty(UpdateFacultyRequest request);
}
