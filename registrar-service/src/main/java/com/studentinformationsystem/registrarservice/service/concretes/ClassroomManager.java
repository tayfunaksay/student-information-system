package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.registrarservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.registrarservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.registrarservice.exception.ClassroomNotFoundException;
import com.studentinformationsystem.registrarservice.repository.ClassroomRepository;
import com.studentinformationsystem.registrarservice.service.ClassroomService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.ClassroomMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassroomManager implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    public ClassroomManager(ClassroomRepository classroomRepository, ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
        this.classroomMapper = classroomMapper;
    }

    @Override
    public ClassroomDto create(CreateClassroomRequest request) {
        return classroomMapper.toClassroomDto(classroomRepository.save(classroomMapper.toClassroom(request)));
    }

    @Override
    public void delete(String classroomId) {
        classroomRepository.deleteById(classroomId);
    }

    @Override
    public ClassroomDto update(UpdateClassroomRequest request) {
        if (classroomRepository.existsById(request.getId())){
            return classroomMapper.toClassroomDto(classroomRepository.save(classroomMapper.toClassroom(request)));
        }else {
            throw new ClassroomNotFoundException("Classroom could not found by id: "+ request.getId());
        }
    }

    @Override
    public List<ClassroomDto> getAll() {
        return classroomMapper.toClassroomDtoList(classroomRepository.findAll());
    }

    @Override
    public ClassroomDto getById(String classroomId) {
        return classroomMapper.toClassroomDto(classroomRepository.findById(classroomId)
                .orElseThrow(()-> new ClassroomNotFoundException("Classroom could not found by id: "+ classroomId)));
    }
}
