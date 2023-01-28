package com.studentinformationsystem.courseschedulingservice.service.semester;

import com.studentinformationsystem.courseschedulingservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.dto.semester.SemesterDto;
import com.studentinformationsystem.courseschedulingservice.dto.semester.UpdateSemesterRequest;

import java.util.List;

public interface SemesterService {
    SemesterDto create(CreateSemesterRequest request);

    void delete(String semesterId);

    SemesterDto update(UpdateSemesterRequest request);

    List<SemesterDto> getAll();

    SemesterDto getById(String semesterId);
}
