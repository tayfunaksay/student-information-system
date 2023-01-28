package com.studentinformationsystem.studentservice.controller;

import com.studentinformationsystem.studentservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.student.StudentDto;
import com.studentinformationsystem.studentservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> create(@RequestBody CreateStudentRequest request) {
        return ResponseEntity.ok(studentService.create(request));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable String studentId) {
        studentService.delete(studentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDto> update(@RequestBody UpdateStudentRequest request) {
        return ResponseEntity.ok(studentService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getById(@PathVariable String studentId) {
        return ResponseEntity.ok(studentService.getById(studentId));
    }

}
