package com.studentinformationsystem.operationservice.service.concretes;

import com.studentinformationsystem.operationservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.operationservice.exception.FacultyNotFoundException;
import com.studentinformationsystem.operationservice.repository.FacultyRepository;
import com.studentinformationsystem.operationservice.service.FacultyService;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.FacultyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyManager implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    public FacultyManager(FacultyRepository facultyRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public FacultyDto create(CreateFacultyRequest request) {
        return facultyMapper.toFacultyDto(facultyRepository.save(facultyMapper.toFaculty(request)));
    }

    @Override
    public void delete(String facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    @Override
    public FacultyDto update(UpdateFacultyRequest request) {
        if (facultyRepository.findById(request.getId()).isEmpty()) {
            throw new FacultyNotFoundException("Faculty could not found by id: " + request.getId());
        } else {
            return facultyMapper.toFacultyDto(facultyRepository.save(facultyMapper.toFaculty(request)));
        }
    }

    @Override
    public List<FacultyDto> getAll() {
        return facultyMapper.toFacultyDtoList(facultyRepository.findAll());
    }

    @Override
    public FacultyDto getById(String facultyId) {
        return facultyMapper.toFacultyDto(facultyRepository.findById(facultyId)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty could not found by id: " + facultyId)));
    }
}
