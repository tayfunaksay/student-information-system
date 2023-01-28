package com.studentinformationsystem.courseschedulingservice.utility.mapping.classroom;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.model.Classroom;

public interface ClassroomMapper {
    ClassroomDto toClassroomDto(Classroom from, DepartmentDto departmentDto);

    Classroom toClassroom(CreateClassroomRequest request);

    Classroom toClassroom(UpdateClassroomRequest request);
}
