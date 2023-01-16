package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.model.Classroom;

import java.util.List;

public interface ClassroomMapper {
    ClassroomDto toClassroomDto(Classroom from);

    List<ClassroomDto> toClassroomDtoList(List<Classroom> from);

    Classroom toClassroom(CreateClassroomRequest request);

    Classroom toClassroom(UpdateClassroomRequest request);
}
