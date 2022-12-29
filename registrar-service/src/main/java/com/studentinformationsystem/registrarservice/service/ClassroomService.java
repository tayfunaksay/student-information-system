package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.registrarservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.registrarservice.dto.classroom.UpdateClassroomRequest;

import java.util.List;

public interface ClassroomService {
    ClassroomDto create(CreateClassroomRequest request);

    void delete(String classroomId);

    ClassroomDto update(UpdateClassroomRequest request);

    List<ClassroomDto> getAll();

    ClassroomDto getById(String classroomId);
}
