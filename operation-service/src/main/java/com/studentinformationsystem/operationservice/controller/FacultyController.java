package com.studentinformationsystem.operationservice.controller;

import com.studentinformationsystem.operationservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.operationservice.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/add")
    public ResponseEntity<FacultyDto> create(@RequestBody CreateFacultyRequest request){
        return ResponseEntity.ok(facultyService.create(request));
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> delete(@PathVariable String facultyId){
        facultyService.delete(facultyId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity<FacultyDto> update(@RequestBody UpdateFacultyRequest request){
        return ResponseEntity.ok(facultyService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FacultyDto>> getAll(){
        return ResponseEntity.ok(facultyService.getAll());
    }
    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyDto> getById(@PathVariable String facultyId){
        return ResponseEntity.ok(facultyService.getById(facultyId));
    }

}
