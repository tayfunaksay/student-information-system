package com.studentinformationsystem.courseschedulingservice.controller;

import com.studentinformationsystem.courseschedulingservice.dto.semester.CreateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.dto.semester.SemesterDto;
import com.studentinformationsystem.courseschedulingservice.dto.semester.UpdateSemesterRequest;
import com.studentinformationsystem.courseschedulingservice.service.abstracts.SemesterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/semester")
public class SemesterController {
    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/add")
    public ResponseEntity<SemesterDto> create(@RequestBody CreateSemesterRequest request) {
        return ResponseEntity.ok(semesterService.create(request));
    }

    @DeleteMapping("/{semesterId}")
    public ResponseEntity<Void> delete(@PathVariable String semesterId) {
        semesterService.delete(semesterId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<SemesterDto> update(@RequestBody UpdateSemesterRequest request) {
        return ResponseEntity.ok(semesterService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SemesterDto>> getAll() {
        return ResponseEntity.ok(semesterService.getAll());
    }

    @GetMapping("/{semesterId}")
    public ResponseEntity<SemesterDto> getById(@PathVariable String semesterId) {
        return ResponseEntity.ok(semesterService.getById(semesterId));
    }
}
