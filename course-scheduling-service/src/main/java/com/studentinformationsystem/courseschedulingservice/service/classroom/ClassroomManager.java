package com.studentinformationsystem.courseschedulingservice.service.classroom;

import com.studentinformationsystem.courseschedulingservice.client.DepartmentServiceClient;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.exception.ClassroomNotFoundException;
import com.studentinformationsystem.courseschedulingservice.model.Classroom;
import com.studentinformationsystem.courseschedulingservice.repository.ClassroomRepository;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.classroom.ClassroomMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomManager implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;
    private final DepartmentServiceClient departmentServiceClient;

    public ClassroomManager(ClassroomRepository classroomRepository, ClassroomMapper classroomMapper, DepartmentServiceClient departmentServiceClient) {
        this.classroomRepository = classroomRepository;
        this.classroomMapper = classroomMapper;
        this.departmentServiceClient = departmentServiceClient;
    }


    @Override
    public ClassroomDto create(CreateClassroomRequest request) {
        Classroom createdClassroom = classroomRepository.save(classroomMapper.toClassroom(request));
        DepartmentDto department = departmentServiceClient.getById(createdClassroom.getDepartmentId()).getBody();
        return classroomMapper.toClassroomDto(createdClassroom,department);
    }

    @Override
    public void delete(String classroomId) {
        classroomRepository.deleteById(classroomId);
    }

    @Override
    public ClassroomDto update(UpdateClassroomRequest request) {
        if (classroomRepository.existsById(request.getId())){
            Classroom createdClassroom = classroomRepository.save(classroomMapper.toClassroom(request));
            DepartmentDto department = departmentServiceClient.getById(createdClassroom.getDepartmentId()).getBody();
            return classroomMapper.toClassroomDto(createdClassroom,department);
        }else {
            throw new ClassroomNotFoundException("Classroom could not found by id: "+ request.getId());
        }
    }


    @Override
    public List<ClassroomDto> getAllByDepartmentId(String departmentId) {
        DepartmentDto departmentDto = departmentServiceClient.getById(departmentId).getBody();
        return classroomRepository.getClassroomsByDepartmentId(departmentId).stream()
                .map(classroom -> classroomMapper.toClassroomDto(classroom,departmentDto))
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomDto getById(String classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(()-> new ClassroomNotFoundException("Classroom could not found by id: "+ classroomId));

        DepartmentDto departmentDto = departmentServiceClient.getById(classroom.getDepartmentId()).getBody();

        return classroomMapper.toClassroomDto(classroom,departmentDto);
    }

}
