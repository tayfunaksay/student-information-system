package com.studentinformationsystem.courseschedulingservice.service.offeredCourse;

import com.studentinformationsystem.courseschedulingservice.client.DepartmentServiceClient;
import com.studentinformationsystem.courseschedulingservice.client.InstructorServiceClient;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.InstructorDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.CreateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.OfferedCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.UpdateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.exception.OfferedCourseNotFoundException;
import com.studentinformationsystem.courseschedulingservice.model.OfferedCourse;
import com.studentinformationsystem.courseschedulingservice.repository.OfferedCourseRepository;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.offeredCourse.OfferedCourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferedCourseManager implements OfferedCourseService {
    private final OfferedCourseRepository repository;
    private final OfferedCourseMapper mapper;
    private final DepartmentServiceClient departmentServiceClient;
    private final InstructorServiceClient instructorServiceClient;

    public OfferedCourseManager(OfferedCourseRepository repository, OfferedCourseMapper mapper, DepartmentServiceClient departmentServiceClient, InstructorServiceClient instructorServiceClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.departmentServiceClient = departmentServiceClient;
        this.instructorServiceClient = instructorServiceClient;
    }
    OfferedCourse offeredCourse;
    DepartmentDto departmentDto;
    InstructorDto instructorDto;

    @Override
    public OfferedCourseDto create(CreateOfferedCourseRequest request) {
        offeredCourse = repository.save(mapper.toOfferedCourse(request));
        departmentDto = departmentServiceClient.getById(offeredCourse.getDepartmentId()).getBody();
        instructorDto = instructorServiceClient.getById(offeredCourse.getInstructorId()).getBody();
        return mapper.toOfferedCourseDto(offeredCourse,departmentDto,instructorDto);
    }

    @Override
    public OfferedCourseDto update(UpdateOfferedCourseRequest request) {
        if (repository.existsById(request.getId())){
            offeredCourse = repository.save(mapper.toOfferedCourse(request));
            departmentDto = departmentServiceClient.getById(offeredCourse.getDepartmentId()).getBody();
            instructorDto = instructorServiceClient.getById(offeredCourse.getInstructorId()).getBody();
            return mapper.toOfferedCourseDto(offeredCourse,departmentDto,instructorDto);
        }else {
            throw new OfferedCourseNotFoundException("Offered Course not found by id: "+request.getId());
        }
    }

    @Override
    public void delete(String offeredCourseId) {
        repository.deleteById(offeredCourseId);
    }

    @Override
    public OfferedCourseDto getById(String offeredCourseId) {
        offeredCourse = repository.findById(offeredCourseId)
                .orElseThrow(()-> new OfferedCourseNotFoundException("Offered Course not found by id: "+offeredCourseId));

        departmentDto =departmentServiceClient.getById(offeredCourse.getDepartmentId()).getBody();
        instructorDto = instructorServiceClient.getById(offeredCourse.getInstructorId()).getBody();

        return mapper.toOfferedCourseDto(offeredCourse,departmentDto,instructorDto);
    }

    @Override
    public List<OfferedCourseDto> getAllByDepartmentIdAndSemesterId(String departmentId, String semesterId) {

        return repository.findAllByDepartmentIdAndSemesterId(departmentId,semesterId).parallelStream()
                .map(offeredCourse1 -> mapper.toOfferedCourseDto(offeredCourse1,
                        departmentServiceClient.getById(offeredCourse1.getDepartmentId()).getBody(),
                        instructorServiceClient.getById(offeredCourse1.getInstructorId()).getBody()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferedCourseDto> getAllByCourseIdAndSemesterId(String courseId, String semesterId) {
        return repository.findAllByCourseIdAndSemesterId(courseId,semesterId).parallelStream()
                .map(offeredCourse1 -> mapper.toOfferedCourseDto(offeredCourse1,
                        departmentServiceClient.getById(offeredCourse1.getDepartmentId()).getBody(),
                        instructorServiceClient.getById(offeredCourse1.getInstructorId()).getBody()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OfferedCourseDto> getAllByInstructorIdAndSemesterId(String instructorId, String semesterId) {
        return repository.findAllByInstructorIdAndSemesterId(instructorId,semesterId).parallelStream()
                .map(offeredCourse1 -> mapper.toOfferedCourseDto(offeredCourse1,
                        departmentServiceClient.getById(offeredCourse1.getDepartmentId()).getBody(),
                        instructorServiceClient.getById(offeredCourse.getInstructorId()).getBody()))
                .collect(Collectors.toList());
    }
}
