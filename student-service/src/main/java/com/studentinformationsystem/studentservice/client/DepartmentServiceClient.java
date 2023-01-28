package com.studentinformationsystem.studentservice.client;

import com.studentinformationsystem.studentservice.dto.clientDto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "operation-service",path = "/v1/department")

public interface DepartmentServiceClient {
    @GetMapping("/{departmentId}")
    ResponseEntity<DepartmentDto> getById(@PathVariable String departmentId);
}
