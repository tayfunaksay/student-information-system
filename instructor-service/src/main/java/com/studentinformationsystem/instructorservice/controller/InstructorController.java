package com.studentinformationsystem.instructorservice.controller;

import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/add")
    public ResponseEntity<InstructorDto> create (CreateInstructorRequest request){
        return ResponseEntity.ok(instructorService.create(request));
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<Void> delete (@PathVariable String instructorId){
        instructorService.delete(instructorId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<InstructorDto> update (UpdateInstructorRequest request){
        return ResponseEntity.ok(instructorService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<InstructorDto>> getAll(){
        return ResponseEntity.ok(instructorService.getAll());
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<InstructorDto> getById(@PathVariable String instructorId){
        return ResponseEntity.ok(instructorService.getById(instructorId));
    }
}
