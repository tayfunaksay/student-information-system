package com.studentinformationsystem.instructorservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "detail-service",path = "/v1/detail")
public interface DetailServiceClient {
    @PostMapping("/add")
    ResponseEntity<String> createDefaultDetail();
}
