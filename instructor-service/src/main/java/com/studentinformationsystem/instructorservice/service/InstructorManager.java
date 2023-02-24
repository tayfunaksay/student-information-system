package com.studentinformationsystem.instructorservice.service;

import com.studentinformationsystem.instructorservice.client.CreateDefaultDetailRequest;
import com.studentinformationsystem.instructorservice.client.DepartmentServiceClient;
import com.studentinformationsystem.instructorservice.client.DetailServiceClient;
import com.studentinformationsystem.instructorservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.exception.InstructorNotFoundException;
import com.studentinformationsystem.instructorservice.model.Instructor;
import com.studentinformationsystem.instructorservice.repository.InstructorRepository;
import com.studentinformationsystem.instructorservice.utility.InstructorMapper;
import com.studentinformationsystem.instructorservice.utility.mailGenerator.EducationalMailGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorManager implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final DetailServiceClient detailServiceClient;
    private final DepartmentServiceClient departmentServiceClient;

    DepartmentDto departmentDto;

    public InstructorManager(InstructorRepository instructorRepository, InstructorMapper instructorMapper, DetailServiceClient detailServiceClient, DepartmentServiceClient departmentServiceClient) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
        this.detailServiceClient = detailServiceClient;
        this.departmentServiceClient = departmentServiceClient;
    }

    @Override
    public InstructorDto create(CreateInstructorRequest request) {
        departmentDto = departmentServiceClient.getById(request.getDepartmentId()).getBody();
        CreateDefaultDetailRequest detailRequest = CreateDefaultDetailRequest.builder()
                .cityId("b1ed3a63-afad-4856-8ded-2b90819cd5c5")
                .districtId("c299b97a-b197-4b08-8d9a-c069dd1d8e8b")
                .build();
        return instructorMapper.toInstructorDto(instructorRepository
                        .save(instructorMapper.toInstructor(request,
                                detailServiceClient.createDefaultDetail(detailRequest).getBody(),
                                EducationalMailGenerator.generate(request.getFirstName(), request.getLastName()))),
                departmentDto);
    }

    @Override
    public void delete(String instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Override
    public InstructorDto update(UpdateInstructorRequest request) {
        if (instructorRepository.existsById(request.getId())) {
            departmentDto = departmentServiceClient.getById(request.getDepartmentId()).getBody();
            return instructorMapper.toInstructorDto(instructorRepository
                    .save(instructorMapper.toInstructor(request)), departmentDto);
        } else {
            throw new InstructorNotFoundException("Instructor could not found by id: " + request.getId());
        }
    }

    @Override
    public List<InstructorDto> getAllByDepartmentId(String departmentId) {
        departmentDto = departmentServiceClient.getById(departmentId).getBody();
        return instructorRepository.findAllByDepartmentId(departmentId).parallelStream()
                .map(instructor -> instructorMapper.toInstructorDto(instructor, departmentDto))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDto getById(String instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor could not found by id: " + instructorId));
        departmentDto = departmentServiceClient.getById(instructor.getDepartmentId()).getBody();
        return instructorMapper.toInstructorDto(instructor, departmentDto);
    }
}
