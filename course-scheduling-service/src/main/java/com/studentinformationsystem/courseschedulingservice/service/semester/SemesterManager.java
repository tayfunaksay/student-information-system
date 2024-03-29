package com.studentinformationsystem.courseschedulingservice.service.semester;

import com.studentinformationsystem.courseschedulingservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.dto.semester.SemesterDto;
import com.studentinformationsystem.courseschedulingservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.exception.SemesterNotFoundException;
import com.studentinformationsystem.courseschedulingservice.repository.SemesterRepository;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.semester.SemesterMapper;
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
