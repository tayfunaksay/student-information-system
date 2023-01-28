package com.studentinformationsystem.courseschedulingservice.service.offeredCourse;

import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.CreateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.OfferedCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.UpdateOfferedCourseRequest;

import java.util.List;

public interface OfferedCourseService {
    OfferedCourseDto create (CreateOfferedCourseRequest request);
    OfferedCourseDto update (UpdateOfferedCourseRequest request);
    void delete (String offeredCourseId);
    OfferedCourseDto getById (String offeredCourseId);
    List<OfferedCourseDto> getAllByDepartmentIdAndSemesterId(String departmentId,String semesterId);
    List<OfferedCourseDto> getAllByCourseIdAndSemesterId(String courseId,String semesterId);
    List<OfferedCourseDto> getAllByInstructorIdAndSemesterId(String instructorId,String semesterId);
}
