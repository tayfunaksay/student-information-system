package com.studentinformationsystem.courseschedulingservice.client;

import com.studentinformationsystem.courseschedulingservice.dto.clientDto.InstructorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "instructor-service",path = "/v1/instructors")
public interface InstructorServiceClient {
    @GetMapping("/{instructorId}")
    ResponseEntity<InstructorDto> getById(@PathVariable String instructorId);
}
