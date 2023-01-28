package com.studentinformationsystem.courseschedulingservice.controller;

import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.CreateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.OfferedCourseDto;
import com.studentinformationsystem.courseschedulingservice.dto.offeredCourse.UpdateOfferedCourseRequest;
import com.studentinformationsystem.courseschedulingservice.service.offeredCourse.OfferedCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/offered_courses")
public class OfferedCourseController {
    private final OfferedCourseService service;

    public OfferedCourseController(OfferedCourseService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<OfferedCourseDto> create(@RequestBody CreateOfferedCourseRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
    @PutMapping("/update")
    public ResponseEntity<OfferedCourseDto> update(@RequestBody UpdateOfferedCourseRequest request) {
        return ResponseEntity.ok(service.update(request));
    }
    @DeleteMapping("/{offeredCourseId}")
    public ResponseEntity<Void> delete(@PathVariable String offeredCourseId) {
        service.delete(offeredCourseId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/getById")
    public ResponseEntity<OfferedCourseDto> getById(@PathVariable String offeredCourseId) {
        return ResponseEntity.ok(service.getById(offeredCourseId));
    }
    @GetMapping("/getByDepartmentAndSemester")
    public ResponseEntity<List<OfferedCourseDto>> getAllByDepartmentIdAndSemesterId(@PathVariable String departmentId,
                                                                                    @PathVariable String semesterId) {
        return ResponseEntity.ok(service.getAllByDepartmentIdAndSemesterId(departmentId, semesterId));
    }
    @GetMapping("/getByCourseAndSemester")
    public ResponseEntity<List<OfferedCourseDto>> getAllByCourseIdAndSemesterId(@PathVariable String courseId,
                                                                                @PathVariable String semesterId) {
        return ResponseEntity.ok(service.getAllByCourseIdAndSemesterId(courseId, semesterId));
    }
    @GetMapping("/getByInstructorAndSemester")
    public ResponseEntity<List<OfferedCourseDto>> getAllByInstructorIdAndSemesterId(@PathVariable String instructorId,
                                                                                    @PathVariable String semesterId) {
        return ResponseEntity.ok(service.getAllByInstructorIdAndSemesterId(instructorId, semesterId));
    }
}
