package com.studentinformationsystem.registrarservice.controller;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.registrarservice.service.DetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/detail")
public class DetailController {
    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }
    @PostMapping("/add")
    public ResponseEntity<DetailDto> create(@RequestBody CreateDetailRequest request) {
        return ResponseEntity.ok(detailService.create(request));
    }
    @DeleteMapping("/{detailId}")
    public ResponseEntity<Void> delete(@PathVariable String detailId) {
        detailService.delete(detailId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update")
    public ResponseEntity<DetailDto> update(@RequestBody UpdateDetailRequest request) {
        return ResponseEntity.ok(detailService.update(request));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<DetailDto>> getAll() {
        return ResponseEntity.ok(detailService.getAll());
    }
    @GetMapping("/{detailId}")
    public ResponseEntity<DetailDto> getById(@PathVariable String detailId) {
        return ResponseEntity.ok(detailService.getById(detailId));
    }
}
