package com.studentinformationsystem.studentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "detail-service",path = "/v1/details")
public interface DetailServiceClient {
    @GetMapping("/add")
    ResponseEntity<String> createDefaultDetail();
}
