package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.registrarservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.registrarservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.registrarservice.model.Classroom;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.ClassroomMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ClassroomConverter implements ClassroomMapper {
    @Override
    public ClassroomDto toClassroomDto(Classroom from) {
        return ClassroomDto.builder()
                .id(from.getId())
                .code(from.getCode())
                .capacity(from.getCapacity())
                .isThereProjectorAndComputer(from.isThereProjectorAndComputer())
                .build();
    }

    @Override
    public List<ClassroomDto> toClassroomDtoList(List<Classroom> from) {
        return from.stream()
                .map(classroom -> toClassroomDto(classroom))
                .collect(Collectors.toList());
    }

    @Override
    public Classroom toClassroom(CreateClassroomRequest request) {
        return Classroom.builder()
                .code(request.getCode())
                .capacity(request.getCapacity())
                .isThereProjectorAndComputer(request.isThereProjectorAndComputer())
                .build();
    }

    @Override
    public Classroom toClassroom(UpdateClassroomRequest request) {
        return Classroom.builder()
                .id(request.getId())
                .code(request.getCode())
                .capacity(request.getCapacity())
                .isThereProjectorAndComputer(request.isThereProjectorAndComputer())
                .build();
    }
}
