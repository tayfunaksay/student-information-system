package com.studentinformationsystem.courseschedulingservice.utility.mapping.offeredCourse;

import com.studentinformationsystem.courseschedulingservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.courseschedulingservice.dto.clientDto.InstructorDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.CreateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.OfferedCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.UpdateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.model.*;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.classroom.ClassroomMapper;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.courseHour.CourseHourMapper;
import com.studentinformationsystem.courseschedulingservice.utility.mapping.semester.SemesterMapper;
import org.springframework.stereotype.Component;

@Component
public class OfferedCourseConverter implements OfferedCourseMapper {

    private final SemesterMapper semesterMapper;
    private final ClassroomMapper classroomMapper;
    private final CourseHourMapper courseHourMapper;

    public OfferedCourseConverter(SemesterMapper semesterMapper, ClassroomMapper classroomMapper, CourseHourMapper courseHourMapper) {
        this.semesterMapper = semesterMapper;
        this.classroomMapper = classroomMapper;
        this.courseHourMapper = courseHourMapper;
    }

    @Override
    public OfferedCourseDto toOfferedCourseDto(OfferedCourse from, DepartmentDto departmentDto, InstructorDto instructorDto) {
        return OfferedCourseDto.builder()
                .id(from.getId())
                .courseName(from.getCourse().getOriginalName())
                .classroom(classroomMapper.toClassroomDto(from.getClassroom(),departmentDto))
                .courseHour(courseHourMapper.toCourseHourDto(from.getCourseHour()))
                .semester(semesterMapper.toSemesterDto(from.getSemester()))
                .departmentName(departmentDto.getName())
                .instructorName(instructorDto.getFirstName()+" "+instructorDto.getLastName())
                .branch(from.getBranch())
                .capacity(from.getCapacity())
                .build();
    }

    @Override
    public OfferedCourse toOfferedCourse(CreateOfferedCourseRequest request) {
        return OfferedCourse.builder()
                .course(Course.builder()
                        .id(request.getCourseId())
                        .build())
                .classroom(Classroom.builder()
                        .id(request.getClassroomId())
                        .build())
                .courseHour(CourseHour.builder()
                        .id(request.getCourseHourId())
                        .build())
                .semester(Semester.builder()
                        .id(request.getSemesterId())
                        .build())
                .departmentId(request.getDepartmentId())
                .instructorId(request.getInstructorId())
                .branch(request.getBranch())
                .capacity(request.getCapacity())
                .build();
    }

    @Override
    public OfferedCourse toOfferedCourse(UpdateOfferedCourseRequest request) {
        return OfferedCourse.builder()
                .id(request.getId())
                .course(Course.builder()
                        .id(request.getCourseId())
                        .build())
                .classroom(Classroom.builder()
                        .id(request.getClassroomId())
                        .build())
                .courseHour(CourseHour.builder()
                        .id(request.getCourseHourId())
                        .build())
                .semester(Semester.builder()
                        .id(request.getSemesterId())
                        .build())
                .departmentId(request.getDepartmentId())
                .instructorId(request.getInstructorId())
                .branch(request.getBranch())
                .capacity(request.getCapacity())
                .build();
    }
}
