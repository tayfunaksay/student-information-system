package com.studentinformationsystem.registrarservice.controller;

import com.studentinformationsystem.registrarservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.registrarservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.registrarservice.service.FacultyService;
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
