package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.registrarservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.registrarservice.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyManager implements FacultyService {
    @Override
    public FacultyDto create(CreateFacultyRequest request) {
        return null;
    }

    @Override
    public FacultyDto delete(long facultyId) {
        return null;
    }

    @Override
    public FacultyDto update(UpdateFacultyRequest request) {
        return null;
    }

    @Override
    public List<FacultyDto> getAll() {
        return null;
    }

    @Override
    public FacultyDto getById(long facultyId) {
        return null;
    }
}
