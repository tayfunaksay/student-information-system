package com.studentinformationsystem.detailservice.controller;

import com.studentinformationsystem.detailservice.dto.detail.CreateDefaultDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.service.DetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/details")
public class DetailController {
    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }
    @GetMapping("/add")
    public ResponseEntity<String> createDefaultDetail(@RequestBody CreateDefaultDetailRequest request) {
        return ResponseEntity.ok(detailService.createDefaultDetail(request));
    }
    @PutMapping("/update")
    public ResponseEntity<DetailDto> update(@RequestBody UpdateDetailRequest request) {
        return ResponseEntity.ok(detailService.update(request));
    }
    @GetMapping("/{detailId}")
    public ResponseEntity<DetailDto> getById(@PathVariable String detailId) {
        return ResponseEntity.ok(detailService.getById(detailId));
    }
}
