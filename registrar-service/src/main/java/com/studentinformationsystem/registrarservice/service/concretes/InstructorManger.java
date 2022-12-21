package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.registrarservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.registrarservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.registrarservice.exception.InstructorNotFoundException;
import com.studentinformationsystem.registrarservice.repository.InstructorRepository;
import com.studentinformationsystem.registrarservice.service.InstructorService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.InstructorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorManger implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorManger(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Override
    public InstructorDto create(CreateInstructorRequest request) {
        return instructorMapper.toInstructorDto(instructorRepository.save(instructorMapper.toInstructor(request)));
    }

    @Override
    public void delete(String instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Override
    public InstructorDto update(UpdateInstructorRequest request) {
        if (instructorRepository.findById(request.getId()).isEmpty()) {
            throw new InstructorNotFoundException("Instructor could not found by id: " + request.getId());
        } else {
            return instructorMapper.toInstructorDto(instructorRepository.save(instructorMapper.toInstructor(request)));
        }
    }

    @Override
    public List<InstructorDto> getAll() {
        return instructorMapper.toInstructorDtoList(instructorRepository.findAll());
    }

    @Override
    public InstructorDto getById(String instructorId) {
        return instructorMapper.toInstructorDto(instructorRepository.findById(instructorId)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor could not found by id: " + instructorId)));
    }
}
