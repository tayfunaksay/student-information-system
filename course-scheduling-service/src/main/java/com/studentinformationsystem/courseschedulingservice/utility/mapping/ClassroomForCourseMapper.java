package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.ClassroomForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.CreateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.UpdateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.ClassroomForCourse;

import java.util.List;

public interface ClassroomForCourseMapper {
    ClassroomForCourseDto toClassroomForCourseDto (ClassroomForCourse from);
    List<ClassroomForCourseDto> toClassroomForCourseDtoList (List<ClassroomForCourse> from);

    ClassroomForCourse toClassroomForCourse (CreateClassroomForCourseRequest request);
    ClassroomForCourse toClassroomForCourse (UpdateClassroomForCourseRequest request);
}
