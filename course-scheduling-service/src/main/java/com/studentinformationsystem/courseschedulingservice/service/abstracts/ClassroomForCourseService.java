package com.studentinformationsystem.courseschedulingservice.service.abstracts;

import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.ClassroomForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.CreateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.UpdateClassroomForCourseRequest;

import java.util.List;

public interface ClassroomForCourseService {
    ClassroomForCourseDto create (CreateClassroomForCourseRequest request);
    ClassroomForCourseDto update (UpdateClassroomForCourseRequest request);
    void delete (String classroomForCourseId);
    List<ClassroomForCourseDto> getAll ();
    List<ClassroomForCourseDto> getAllAvailableClassroomWithCourseId (String courseId);
}
