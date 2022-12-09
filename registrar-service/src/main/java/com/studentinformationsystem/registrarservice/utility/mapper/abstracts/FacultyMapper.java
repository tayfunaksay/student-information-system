package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.registrarservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.registrarservice.model.Faculty;

import java.util.List;

public interface FacultyMapper {
    FacultyDto toFacultyDto(Faculty from);
    List<FacultyDto> toFacultyDtoList (List<Faculty> from);
    Faculty toFaculty(CreateFacultyRequest request);
    Faculty toFaculty(UpdateFacultyRequest request);
}
