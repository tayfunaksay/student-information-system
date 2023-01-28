package com.studentinformationsystem.courseschedulingservice.utility.mapping.classroom;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.model.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomConverter implements ClassroomMapper {
    @Override
    public ClassroomDto toClassroomDto(Classroom from, DepartmentDto departmentDto) {
        return ClassroomDto.builder()
                .id(from.getId())
                .departmentName(departmentDto.getName())
                .code(from.getCode())
                .capacity(from.getCapacity())
                .isThereProjectorAndComputer(from.isThereProjectorAndComputer())
                .build();
    }

    @Override
    public Classroom toClassroom(CreateClassroomRequest request) {
        return Classroom.builder()
                .departmentId(request.getDepartmentId())
                .code(request.getCode())
                .capacity(request.getCapacity())
                .isThereProjectorAndComputer(request.isThereProjectorAndComputer())
                .build();
    }

    @Override
    public Classroom toClassroom(UpdateClassroomRequest request) {
        return Classroom.builder()
                .id(request.getId())
                .departmentId(request.getDepartmentId())
                .code(request.getCode())
                .capacity(request.getCapacity())
                .isThereProjectorAndComputer(request.isThereProjectorAndComputer())
                .build();
    }
}
