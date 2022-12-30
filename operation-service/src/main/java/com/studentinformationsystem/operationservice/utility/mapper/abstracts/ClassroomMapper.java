package com.studentinformationsystem.operationservice.utility.mapper.abstracts;

import com.studentinformationsystem.operationservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.operationservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.operationservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.operationservice.model.Classroom;

import java.util.List;

public interface ClassroomMapper {
    ClassroomDto toClassroomDto(Classroom from);

    List<ClassroomDto> toClassroomDtoList(List<Classroom> from);

    Classroom toClassroom(CreateClassroomRequest request);

    Classroom toClassroom(UpdateClassroomRequest request);
}
