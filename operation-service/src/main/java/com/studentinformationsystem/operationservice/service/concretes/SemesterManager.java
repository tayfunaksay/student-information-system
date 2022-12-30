package com.studentinformationsystem.operationservice.service.concretes;

import com.studentinformationsystem.operationservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.operationservice.dto.semester.SemesterDto;
import com.studentinformationsystem.operationservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.operationservice.exception.SemesterNotFoundException;
import com.studentinformationsystem.operationservice.repository.SemesterRepository;
import com.studentinformationsystem.operationservice.service.SemesterService;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.SemesterMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterManager implements SemesterService {
    private final SemesterRepository semesterRepository;
    private final SemesterMapper semesterMapper;

    public SemesterManager(SemesterRepository semesterRepository, SemesterMapper semesterMapper) {
        this.semesterRepository = semesterRepository;
        this.semesterMapper = semesterMapper;
    }

    @Override
    public SemesterDto create(CreateSemesterRequest request) {
        return semesterMapper.toSemesterDto(semesterRepository.save(semesterMapper.toSemester(request)));
    }

    @Override
    public void delete(String semesterId) {
        semesterRepository.deleteById(semesterId);
    }

    @Override
    public SemesterDto update(UpdateSemesterRequest request) {
        if (semesterRepository.findById(request.getId()).isEmpty()) {
            throw new SemesterNotFoundException("Semester could not found by id: " + request.getId());
        } else {
            return semesterMapper.toSemesterDto(semesterRepository.save(semesterMapper.toSemester(request)));
        }
    }

    @Override
    public List<SemesterDto> getAll() {
        return semesterMapper.toSemesterDtoList(semesterRepository.findAll());
    }

    @Override
    public SemesterDto getById(String semesterId) {
        return semesterMapper.toSemesterDto(semesterRepository.findById(semesterId)
                .orElseThrow(() -> new SemesterNotFoundException("Semester could not found by id: " + semesterId)));
    }
}
