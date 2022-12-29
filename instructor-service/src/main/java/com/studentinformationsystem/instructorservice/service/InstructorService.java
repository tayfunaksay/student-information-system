package com.studentinformationsystem.instructorservice.service;

import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;

import java.util.List;

public interface InstructorService {
    InstructorDto create(CreateInstructorRequest request);

    void delete(String instructorId);

    InstructorDto update(UpdateInstructorRequest request);

    List<InstructorDto> getAll();

    InstructorDto getById(String instructorId);
}
