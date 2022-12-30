package com.studentinformationsystem.operationservice.utility.mapper.concretes;

import com.studentinformationsystem.operationservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.operationservice.dto.semester.SemesterDto;
import com.studentinformationsystem.operationservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.operationservice.model.Semester;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.SemesterMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SemesterConverter implements SemesterMapper {
    @Override
    public SemesterDto toSemesterDto(Semester from) {
        return SemesterDto.builder()
                .id(from.getId())
                .name(from.getName())
                .startDate(from.getStartDate())
                .finishDate(from.getFinishDate())
                .build();
    }
    @Override
    public List<SemesterDto> toSemesterDtoList(List<Semester> from) {
        return from.stream()
                .map(semester -> toSemesterDto(semester))
                .collect(Collectors.toList());
    }

    @Override
    public Semester toSemester(CreateSemesterRequest request) {
        return Semester.builder()
                .name(request.getName())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .build();
    }

    @Override
    public Semester toSemester(UpdateSemesterRequest request) {
        return Semester.builder()
                .id(request.getId())
                .name(request.getName())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .build();
    }
}
