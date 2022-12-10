package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.registrarservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.registrarservice.model.Faculty;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.FacultyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacultyConverter implements FacultyMapper {
    @Override
    public FacultyDto toFacultyDto(Faculty from) {
        return FacultyDto.builder()
                .id(from.getId())
                .name(from.getName())
                .build();
    }

    @Override
    public List<FacultyDto> toFacultyDtoList(List<Faculty> from) {
        return from.stream()
                .map(faculty -> toFacultyDto(faculty))
                .collect(Collectors.toList());
    }

    @Override
    public Faculty toFaculty(CreateFacultyRequest request) {
        return Faculty.builder()
                .name(request.getName())
                .build();
    }

    @Override
    public Faculty toFaculty(UpdateFacultyRequest request) {
        return Faculty.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
