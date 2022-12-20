package com.studentinformationsystem.registrarservice.controller;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.registrarservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.registrarservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping("/add")
    public ResponseEntity<CityDto> create(@RequestBody CreateCityRequest request) {
        return ResponseEntity.ok(cityService.create(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CityDto> update(@RequestBody UpdateCityRequest request) {
        return ResponseEntity.ok(cityService.update(request));
    }

    @GetMapping("/getAll")
    public List<CityDto> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{cityId}")
    public CityDto getById(@PathVariable String cityId) {
        return cityService.getById(cityId);
    }



}
