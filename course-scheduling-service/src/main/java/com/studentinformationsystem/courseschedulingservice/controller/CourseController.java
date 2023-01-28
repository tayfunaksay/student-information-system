package com.studentinformationsystem.courseschedulingservice.controller;

import com.studentinformationsystem.courseschedulingservice.dto.course.CourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.course.CreateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.course.UpdateCourseRequest;
import com.studentinformationsystem.courseschedulingservice.service.course.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/courses")
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

    @GetMapping("/getAllByDepartmentId")
    public ResponseEntity<List<CourseDto>> getAllByDepartmentId(String departmentId) {
        return ResponseEntity.ok(courseService.getAllByDepartmentId(departmentId));

    }
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getById(@PathVariable String courseId) {
        return ResponseEntity.ok(courseService.getById(courseId));
    }


}
