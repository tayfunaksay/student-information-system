package com.studentinformationsystem.operationservice.service;

import com.studentinformationsystem.operationservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.operationservice.dto.semester.SemesterDto;
import com.studentinformationsystem.operationservice.dto.semester.UpdateSemesterRequest;

import java.util.List;

public interface SemesterService {
    SemesterDto create(CreateSemesterRequest request);

    void delete(String semesterId);

    SemesterDto update(UpdateSemesterRequest request);

    List<SemesterDto> getAll();

    SemesterDto getById(String semesterId);
}
