package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.registrarservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.registrarservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.registrarservice.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorManger implements InstructorService {
    @Override
    public InstructorDto create(CreateInstructorRequest request) {
        return null;
    }

    @Override
    public InstructorDto delete(long instructorId) {
        return null;
    }

    @Override
    public InstructorDto update(UpdateInstructorRequest request) {
        return null;
    }

    @Override
    public List<InstructorDto> getAll() {
        return null;
    }

    @Override
    public InstructorDto getById(long instructorId) {
        return null;
    }
}
