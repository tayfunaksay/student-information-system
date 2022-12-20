package com.studentinformationsystem.registrarservice.controller;

import com.studentinformationsystem.registrarservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import com.studentinformationsystem.registrarservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.registrarservice.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/district")
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping("/add")
    public ResponseEntity<DistrictDto> create(@RequestBody CreateDistrictRequest request) {
        return ResponseEntity.ok(districtService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<DistrictDto> update(@RequestBody UpdateDistrictRequest request) {
        return ResponseEntity.ok(districtService.update(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DistrictDto>> getAll() {
        return ResponseEntity.ok(districtService.getAll());
    }

    @GetMapping("/{districtId}")
    public ResponseEntity<DistrictDto> getById(String districtId) {
        return ResponseEntity.ok(districtService.getById(districtId));
    }
}
