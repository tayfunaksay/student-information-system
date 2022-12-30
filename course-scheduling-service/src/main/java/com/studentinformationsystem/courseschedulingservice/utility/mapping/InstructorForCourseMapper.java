package com.studentinformationsystem.courseschedulingservice.utility.mapping;

import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.CreateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.InstructorForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse.UpdateInstructorForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.InstructorForCourse;

import java.util.List;

public interface InstructorForCourseMapper {
    InstructorForCourseDto toInstructorForCourseDto (InstructorForCourse from);
    List<InstructorForCourseDto> toInstructorForCourseDtoList (List<InstructorForCourse> from);
    InstructorForCourse toInstructorForCourse (CreateInstructorForCourseRequest request);
    InstructorForCourse toInstructorForCourse (UpdateInstructorForCourseRequest request);
}
