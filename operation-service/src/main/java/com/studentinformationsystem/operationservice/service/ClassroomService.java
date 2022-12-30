package com.studentinformationsystem.operationservice.service;

import com.studentinformationsystem.operationservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.operationservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.operationservice.dto.classroom.UpdateClassroomRequest;

import java.util.List;

public interface ClassroomService {
    ClassroomDto create(CreateClassroomRequest request);

    void delete(String classroomId);

    ClassroomDto update(UpdateClassroomRequest request);

    List<ClassroomDto> getAll();

    ClassroomDto getById(String classroomId);

    String getNameById(String classroomId);
}
