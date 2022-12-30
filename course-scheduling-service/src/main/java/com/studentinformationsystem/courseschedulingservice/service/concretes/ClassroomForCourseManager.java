package com.studentinformationsystem.courseschedulingservice.service.concretes;

import com.studentinformationsystem.courseschedulingservice.client.CourseServiceClient;
import com.studentinformationsystem.courseschedulingservice.client.RegistrarServiceClient;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.ClassroomForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.CreateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.UpdateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.exception.ClassroomForCourseNotFoundException;
import com.studentinformationsystem.courseschedulingservice.model.ClassroomForCourse;
import com.studentinformationsystem.courseschedulingservice.repository.ClassroomForCourseRepository;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.ClassroomForCourseService;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.ClassroomForCourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClassroomForCourseManager implements ClassroomForCourseService {
    private final ClassroomForCourseRepository repository;
    private final ClassroomForCourseMapper mapper;
    private final CourseServiceClient courseServiceClient;
    private final RegistrarServiceClient registrarServiceClient;

    public ClassroomForCourseManager(ClassroomForCourseRepository repository, ClassroomForCourseMapper mapper, CourseServiceClient courseServiceClient, RegistrarServiceClient registrarServiceClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.courseServiceClient = courseServiceClient;
        this.registrarServiceClient = registrarServiceClient;
    }

    @Override
    public ClassroomForCourseDto create(CreateClassroomForCourseRequest request) {
        ClassroomForCourse created = repository.save(mapper.toClassroomForCourse(request));
        return ClassroomForCourseDto.builder()
                .id(created.getId())
                .courseName(Objects.requireNonNull(courseServiceClient.getNamesById(created.getCourseId()).getBody()).getOriginalName())
                .classroomName(registrarServiceClient.getNameById(created.getClassroomId()).getBody())
                .build();
    }

    @Override
    public ClassroomForCourseDto update(UpdateClassroomForCourseRequest request) {
        if (repository.existsById(request.getId())){
            return mapper.toClassroomForCourseDto(repository.save(mapper.toClassroomForCourse(request)));
        }else {
            throw new ClassroomForCourseNotFoundException(
                    "Classroom and Course match could not found to update by id: "+request.getId());
        }
    }

    @Override
    public void delete(String classroomForCourseId) {
        repository.deleteById(classroomForCourseId);
    }

    @Override
    public List<ClassroomForCourseDto> getAll() {
        return mapper.toClassroomForCourseDtoList(repository.findAll());
    }

    @Override
    public List<ClassroomForCourseDto> getAllAvailableClassroomWithCourseId(String courseId) {
        return mapper.toClassroomForCourseDtoList(repository.findAllByCourseIdIs(courseId));
    }
}
