package com.studentinformationsystem.instructorservice.utility;

import com.studentinformationsystem.instructorservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.model.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorConverter implements InstructorMapper {
    @Override
    public InstructorDto toInstructorDto(Instructor from, DepartmentDto departmentDto) {
        return InstructorDto.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .educationalEmail(from.getEducationalEmail())
                .nationalIdentity(from.getNationalIdentity())
                .gender(from.getGender())
                .departmentName(departmentDto.getName())
                .detailId(from.getDetailId())
                .build();
    }

    @Override
    public Instructor toInstructor(CreateInstructorRequest request,String detailId,String educationalEmail) {
        return Instructor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(educationalEmail)
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .departmentId(request.getDepartmentId())
                .detailId(detailId)
                .build();
    }

    @Override
    public Instructor toInstructor(UpdateInstructorRequest request) {
        return Instructor.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .departmentId(request.getDepartmentId())
                .build();
    }
}
