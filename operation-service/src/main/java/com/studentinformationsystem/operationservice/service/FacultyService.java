package com.studentinformationsystem.operationservice.service;

import com.studentinformationsystem.operationservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.dto.faculty.UpdateFacultyRequest;

import java.util.List;

public interface FacultyService {
    FacultyDto create(CreateFacultyRequest request);

    void delete(String facultyId);

    FacultyDto update(UpdateFacultyRequest request);

    List<FacultyDto> getAll();

    FacultyDto getById(String facultyId);
}
