package com.studentinformationsystem.registrarservice.controller;

import com.studentinformationsystem.registrarservice.dto.staff.CreateStaffRequest;
import com.studentinformationsystem.registrarservice.dto.staff.StaffDto;
import com.studentinformationsystem.registrarservice.dto.staff.UpdateStaffRequest;
import com.studentinformationsystem.registrarservice.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/add")
    public ResponseEntity<StaffDto> create(@RequestBody CreateStaffRequest request) {
        return ResponseEntity.ok(staffService.create(request));
    }

    @DeleteMapping("/{staffId}")
    public ResponseEntity<Void> delete(@PathVariable String staffId) {
        staffService.delete(staffId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<StaffDto> update(@RequestBody UpdateStaffRequest request) {
        return ResponseEntity.ok(staffService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StaffDto>> getAll() {
        return ResponseEntity.ok(staffService.getAll());
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<StaffDto> getById(@PathVariable String staffId) {
        return ResponseEntity.ok(staffService.getById(staffId));
    }

}
