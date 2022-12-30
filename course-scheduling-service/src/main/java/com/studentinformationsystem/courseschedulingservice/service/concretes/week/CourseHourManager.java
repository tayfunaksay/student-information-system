package com.studentinformationsystem.courseschedulingservice.service.concretes.week;

import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.week.courseHour.UpdateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.exception.CourseHourNotFoundException;
import com.studentinformationsystem.courseschedulingservice.repository.week.CourseHourRepository;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.week.CourseHourService;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.week.CourseHourMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseHourManager implements CourseHourService {
    private final CourseHourRepository courseHourRepository;
    private final CourseHourMapper courseHourMapper;

    public CourseHourManager(CourseHourRepository courseHourRepository, CourseHourMapper courseHourMapper) {
        this.courseHourRepository = courseHourRepository;
        this.courseHourMapper = courseHourMapper;
    }

    @Override
    public CourseHourDto create(CreateCourseHourRequest request) {
        return courseHourMapper.toCourseHourDto(courseHourRepository.save(courseHourMapper.toCourseHour(request)));
    }

    @Override
    public CourseHourDto update(UpdateCourseHourRequest request) {
        if (courseHourRepository.existsById(request.getId())){
            return courseHourMapper.toCourseHourDto(courseHourRepository.save(courseHourMapper.toCourseHour(request)));
        }else {
            throw new CourseHourNotFoundException("Course Hour could not found by id: "+request.getId());
        }
    }

    @Override
    public void delete(Long courseHourId) {
        courseHourRepository.deleteById(courseHourId);
    }

    @Override
    public List<CourseHourDto> getAll() {
        return courseHourMapper.toCourseHourDtoList(courseHourRepository.findAll());
    }

    @Override
    public List<CourseHourDto> getAllAvailableCourseHour() {
        return courseHourMapper.toCourseHourDtoList(courseHourRepository.findAllAvailableCourseHour());
    }
}
