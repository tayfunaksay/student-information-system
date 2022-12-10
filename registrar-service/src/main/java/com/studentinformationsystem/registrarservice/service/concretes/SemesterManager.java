package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.registrarservice.dto.semester.SemesterDto;
import com.studentinformationsystem.registrarservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.registrarservice.service.SemesterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterManager implements SemesterService {
    @Override
    public SemesterDto create(CreateSemesterRequest request) {
        return null;
    }

    @Override
    public SemesterDto delete(String semesterId) {
        return null;
    }

    @Override
    public SemesterDto update(UpdateSemesterRequest request) {
        return null;
    }

    @Override
    public List<SemesterDto> getAll() {
        return null;
    }

    @Override
    public SemesterDto getById(String semesterId) {
        return null;
    }
}
