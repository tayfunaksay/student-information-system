package com.studentinformationsystem.operationservice.utility.mapper.concretes;

import com.studentinformationsystem.operationservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.operationservice.model.Faculty;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.FacultyMapper;
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
    public Faculty toFaculty(FacultyDto fromDto) {
        return Faculty.builder()
                .id(fromDto.getId())
                .name(fromDto.getName())
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
