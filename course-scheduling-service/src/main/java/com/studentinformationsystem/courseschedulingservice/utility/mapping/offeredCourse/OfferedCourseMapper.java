package com.studentinformationsystem.courseschedulingservice.utility.mapping.offeredCourse;

import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.InstructorDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.CreateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.OfferedCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.UpdateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.OfferedCourse;

public interface OfferedCourseMapper {
    OfferedCourseDto toOfferedCourseDto (OfferedCourse from, DepartmentDto departmentDto, InstructorDto instructorDto);
    OfferedCourse toOfferedCourse (CreateOfferedCourseRequest request);
    OfferedCourse toOfferedCourse (UpdateOfferedCourseRequest request);
}
