package com.studentinformationsystem.courseservice.controller;

import com.studentinformationsystem.courseservice.dto.course.CourseDto;
import com.studentinformationsystem.courseservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseservice.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/course")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<CourseDto> create(@RequestBody CreateCourseRequest request) {
        return ResponseEntity.ok(courseService.create(request));
    }
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> delete(@PathVariable String courseId) {
        courseService.delete(courseId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity<CourseDto> update(@RequestBody UpdateCourseRequest request) {
        return ResponseEntity.ok(courseService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CourseDto>> getAll() {
        return ResponseEntity.ok(courseService.getAll());

    }
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getById(@PathVariable String courseId) {
        return ResponseEntity.ok(courseService.getById(courseId));
    }


}
