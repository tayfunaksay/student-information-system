package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.registrarservice.dto.faculty.UpdateFacultyRequest;

import java.util.List;

public interface FacultyService {
    FacultyDto create (CreateFacultyRequest request);
    FacultyDto delete (String facultyId);
    FacultyDto update (UpdateFacultyRequest request);
    List<FacultyDto> getAll();
    FacultyDto getById(String facultyId);
}
