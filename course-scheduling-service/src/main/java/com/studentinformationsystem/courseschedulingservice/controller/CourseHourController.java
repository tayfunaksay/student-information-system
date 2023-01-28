package com.studentinformationsystem.courseschedulingservice.controller;

import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CreateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.UpdateCourseHourRequest;
import com.studentinformationsystem.courseschedulingservice.service.courseHour.CourseHourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/course_hours")
public class CourseHourController {
    private final CourseHourService service;

    public CourseHourController(CourseHourService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<CourseHourDto> create(CreateCourseHourRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
    @PutMapping("/update")
    public ResponseEntity<CourseHourDto> update(UpdateCourseHourRequest request) {
        return ResponseEntity.ok(service.update(request));
    }
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> delete(String courseHourId) {
        service.delete(courseHourId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<CourseHourDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
