package com.studentinformationsystem.courseschedulingservice.service.concretes;

import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.CreateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.InstructorForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.UpdateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.InstructorForCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorForCourseManager implements InstructorForCourseService {
    @Override
    public InstructorForCourseDto create(CreateInstructorForCourseRequest request) {
        return null;
    }

    @Override
    public InstructorForCourseDto update(UpdateInstructorForCourseRequest request) {
        return null;
    }

    @Override
    public void delete(String instructorForCourseId) {

    }

    @Override
    public List<InstructorForCourseDto> getAll() {
        return null;
    }

    @Override
    public List<InstructorForCourseDto> getAllCourseWithInstructorId(String instructorId) {
        return null;
    }
}
