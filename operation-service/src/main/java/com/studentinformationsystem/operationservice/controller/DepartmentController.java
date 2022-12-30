package com.studentinformationsystem.operationservice.controller;

import com.studentinformationsystem.operationservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.operationservice.dto.department.DepartmentDto;
import com.studentinformationsystem.operationservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.operationservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentDto> create(@RequestBody CreateDepartmentRequest request) {
        return ResponseEntity.ok(departmentService.create(request));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> delete(@PathVariable String departmentId) {
        departmentService.delete(departmentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<DepartmentDto> update(@RequestBody UpdateDepartmentRequest request) {
        return ResponseEntity.ok(departmentService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable String departmentId) {
        return ResponseEntity.ok(departmentService.getById(departmentId));
    }

}
