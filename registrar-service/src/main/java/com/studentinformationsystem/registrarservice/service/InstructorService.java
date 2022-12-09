package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.registrarservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.registrarservice.dto.instructor.UpdateInstructorRequest;

import java.util.List;

public interface InstructorService {
    InstructorDto create (CreateInstructorRequest request);
    InstructorDto delete (long instructorId);
    InstructorDto update (UpdateInstructorRequest request);
    List<InstructorDto> getAll();
    InstructorDto getById(long instructorId);
}
