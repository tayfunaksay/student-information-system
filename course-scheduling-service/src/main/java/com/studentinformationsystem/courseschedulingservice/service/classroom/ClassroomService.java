package com.studentinformationsystem.courseschedulingservice.service.classroom;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;

import java.util.List;

public interface ClassroomService {
    ClassroomDto create(CreateClassroomRequest request);

    void delete(String classroomId);

    ClassroomDto update(UpdateClassroomRequest request);


    List<ClassroomDto> getAllByDepartmentId(String departmentId);

    ClassroomDto getById(String classroomId);

}
