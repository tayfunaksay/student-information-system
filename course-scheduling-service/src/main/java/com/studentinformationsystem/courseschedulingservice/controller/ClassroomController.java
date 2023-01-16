package com.studentinformationsystem.courseschedulingservice.controller;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.CreateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.dto.classroom.UpdateClassroomRequest;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping("/add")
    public ResponseEntity<ClassroomDto> create(@RequestBody CreateClassroomRequest request) {
        return ResponseEntity.ok(classroomService.create(request));
    }

    @DeleteMapping("/{classroomId}")
    public ResponseEntity<Void> delete(@PathVariable String classroomId) {
        classroomService.delete(classroomId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ClassroomDto> update(@RequestBody UpdateClassroomRequest request) {
        return ResponseEntity.ok(classroomService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClassroomDto>> getAll() {
        return ResponseEntity.ok(classroomService.getAll());
    }

    @GetMapping("/{classroomId}")
    public ResponseEntity<ClassroomDto> getById(@PathVariable String classroomId) {
        return ResponseEntity.ok(classroomService.getById(classroomId));
    }
    @GetMapping("/getName/{classroomId}")
    public ResponseEntity<String> getNameById(@PathVariable String classroomId) {
        return ResponseEntity.ok(classroomService.getNameById(classroomId));
    }
}
