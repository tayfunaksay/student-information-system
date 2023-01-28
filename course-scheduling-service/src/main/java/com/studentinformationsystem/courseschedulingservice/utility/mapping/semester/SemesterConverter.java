package com.studentinformationsystem.courseschedulingservice.utility.mapping.semester;

import com.studentinformationsystem.courseschedulingservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.dto.semester.SemesterDto;
import com.studentinformationsystem.courseschedulingservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.model.Semester;
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
                .classLevel(from.getClassLevel())
                .semesterType(from.getSemesterType())
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
                .classLevel(request.getClassLevel())
                .semesterType(request.getSemesterType())
                .build();
    }

    @Override
    public Semester toSemester(UpdateSemesterRequest request) {
        return Semester.builder()
                .id(request.getId())
                .name(request.getName())
                .classLevel(request.getClassLevel())
                .semesterType(request.getSemesterType())
                .build();
    }
}
