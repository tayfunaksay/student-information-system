package com.studentinformationsystem.courseschedulingservice.controller;

import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.ClassroomForCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse.CreateClassroomForCourseRequest;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.ClassroomForCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/classrooms_for_courses")
public class ClassroomFourCourseController {
    private final ClassroomForCourseService service;

    public ClassroomFourCourseController(ClassroomForCourseService service) {
        this.service = service;
    }

    @PostMapping("/add")
    ResponseEntity<ClassroomForCourseDto> create(@RequestBody CreateClassroomForCourseRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
}
