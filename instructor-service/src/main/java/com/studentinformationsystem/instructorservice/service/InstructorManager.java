package com.studentinformationsystem.instructorservice.service;

import com.studentinformationsystem.instructorservice.client.DetailServiceClient;
import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.exception.InstructorNotFoundException;
import com.studentinformationsystem.instructorservice.repository.InstructorRepository;
import com.studentinformationsystem.instructorservice.utility.InstructorMapper;
import com.studentinformationsystem.instructorservice.utility.mailGenerator.EducationalMailGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorManager implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final DetailServiceClient detailServiceClient;

    public InstructorManager(InstructorRepository instructorRepository, InstructorMapper instructorMapper, DetailServiceClient detailServiceClient) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
        this.detailServiceClient = detailServiceClient;
    }

    @Override
    public InstructorDto create(CreateInstructorRequest request) {

        return instructorMapper.toInstructorDto(instructorRepository
                .save(instructorMapper.toInstructor(request,
                        detailServiceClient.createDefaultDetail().getBody(),
                        EducationalMailGenerator.generate(request.getFirstName(),request.getLastName()))));
    }

    @Override
    public void delete(String instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Override
    public InstructorDto update(UpdateInstructorRequest request) {
        if (instructorRepository.existsById(request.getId())){
            return instructorMapper.toInstructorDto(instructorRepository.save(instructorMapper.toInstructor(request)));
        }else {
            throw new InstructorNotFoundException("Instructor could not found by id: "+request.getId());
        }
    }

    @Override
    public List<InstructorDto> getAll() {
        return instructorMapper.toInstructorDtoList(instructorRepository.findAll());
    }

    @Override
    public InstructorDto getById(String instructorId) {
        return instructorMapper.toInstructorDto(instructorRepository.findById(instructorId)
                .orElseThrow(()-> new InstructorNotFoundException("Instructor could not found by id: "+ instructorId)));
    }
}
