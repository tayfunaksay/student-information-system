package com.studentinformationsystem.instructorservice.utility;

import com.studentinformationsystem.instructorservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.model.Instructor;

public interface InstructorMapper {
    InstructorDto toInstructorDto(Instructor from, DepartmentDto departmentDto);

    Instructor toInstructor(CreateInstructorRequest request,String detailId,String educationalEmail);

    Instructor toInstructor(UpdateInstructorRequest request);
}
