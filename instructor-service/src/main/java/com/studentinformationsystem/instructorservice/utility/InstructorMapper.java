package com.studentinformationsystem.instructorservice.utility;

import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.model.Instructor;

import java.util.List;

public interface InstructorMapper {
    InstructorDto toInstructorDto(Instructor from);

    List<InstructorDto> toInstructorDtoList(List<Instructor> from);

    Instructor toInstructor(CreateInstructorRequest request,String departmentId,String educationalEmail);

    Instructor toInstructor(UpdateInstructorRequest request);
}
