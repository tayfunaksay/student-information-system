package com.studentinformationsystem.courseschedulingservice.service.concretes;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.exception.ClassroomNotFoundException;
import com.studentinformationsystem.courseschedulingservice.repository.ClassroomRepository;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.ClassroomService;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.ClassroomMapper;
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

    @Override
    public String getNameById(String classroomId) {
        return classroomRepository.findNameById(classroomId)
                .orElseThrow(()-> new ClassroomNotFoundException("Classroom could not found by id: "+ classroomId));
    }
}
