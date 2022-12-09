package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.registrarservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.registrarservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.registrarservice.model.Instructor;

import java.util.List;

public interface InstructorMapper {
    InstructorDto toInstructorDto(Instructor from);
    List<InstructorDto> toInstructorDtoList (List<Instructor> from);
    Instructor toInstructor(CreateInstructorRequest request);
    Instructor toInstructor(UpdateInstructorRequest request);
}
