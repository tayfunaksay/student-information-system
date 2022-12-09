package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.registrarservice.dto.semester.SemesterDto;
import com.studentinformationsystem.registrarservice.dto.semester.UpdateSemesterRequest;

import java.util.List;

public interface SemesterService {
    SemesterDto create (CreateSemesterRequest request);
    SemesterDto delete (long semesterId);
    SemesterDto update (UpdateSemesterRequest request);
    List<SemesterDto> getAll();
    SemesterDto getById(long semesterId);
}
