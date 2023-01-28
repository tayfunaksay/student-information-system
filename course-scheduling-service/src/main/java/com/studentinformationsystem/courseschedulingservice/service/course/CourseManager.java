package com.studentinformationsystem.courseschedulingservice.service.course;

import com.studentinformationsystem.courseschedulingservice.client.DepartmentServiceClient;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.exception.CourseNotFoundException;
import com.studentinformationsystem.courseschedulingservice.model.Course;
import com.studentinformationsystem.courseschedulingservice.repository.CourseRepository;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.course.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseManager implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final DepartmentServiceClient departmentServiceClient;

    public CourseManager(CourseRepository courseRepository, CourseMapper courseMapper, DepartmentServiceClient departmentServiceClient) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.departmentServiceClient = departmentServiceClient;
    }

    @Override
    public CourseDto create(CreateCourseRequest request) {
        Course createdCourse = courseRepository.save(courseMapper.toCourse(request));
        DepartmentDto departmentDto = departmentServiceClient.getById(createdCourse.getDepartmentId()).getBody();
        return courseMapper.toCourseDto(createdCourse,departmentDto);
    }

    @Override
    public void delete(String courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public CourseDto update(UpdateCourseRequest request) {
        if (courseRepository.existsById(request.getId())){
            Course updatedCourse = courseRepository.save(courseMapper.toCourse(request));
            DepartmentDto departmentDto = departmentServiceClient.getById(updatedCourse.getDepartmentId()).getBody();
            return courseMapper.toCourseDto(updatedCourse,departmentDto);
        }else {
            throw new CourseNotFoundException("Course could not found by id: "+request.getId());
        }
    }

    @Override
    public List<CourseDto> getAllByDepartmentId(String departmentId) {
        DepartmentDto departmentDto = departmentServiceClient.getById(departmentId).getBody();
        return courseRepository.findCoursesByDepartmentId(departmentId).stream()
                .map(course -> courseMapper.toCourseDto(course,departmentDto))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getById(String courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException("Course could not found by id: "+courseId));
        DepartmentDto departmentDto = departmentServiceClient.getById(course.getDepartmentId()).getBody();
        return courseMapper.toCourseDto(course,departmentDto);
    }
}
