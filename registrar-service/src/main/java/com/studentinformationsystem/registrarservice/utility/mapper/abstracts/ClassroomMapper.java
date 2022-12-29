package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.registrarservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.registrarservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.registrarservice.model.Classroom;

import java.util.List;

public interface ClassroomMapper {
    ClassroomDto toClassroomDto(Classroom from);

    List<ClassroomDto> toClassroomDtoList(List<Classroom> from);

    Classroom toClassroom(CreateClassroomRequest request);

    Classroom toClassroom(UpdateClassroomRequest request);
}
