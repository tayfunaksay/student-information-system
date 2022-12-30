package com.studentinformationsystem.courseschedulingservice.service.abstracts;

import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.CreateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.InstructorForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.UpdateInstructorForCourseRequest;

import java.util.List;

public interface InstructorForCourseService {
    InstructorForCourseDto create (CreateInstructorForCourseRequest request);
    InstructorForCourseDto update (UpdateInstructorForCourseRequest request);
    void delete (String instructorForCourseId);
    List<InstructorForCourseDto> getAll ();
    List<InstructorForCourseDto> getAllCourseWithInstructorId (String instructorId);
}
