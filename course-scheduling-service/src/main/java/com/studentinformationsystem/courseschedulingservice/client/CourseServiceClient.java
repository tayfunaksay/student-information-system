package com.studentinformationsystem.courseschedulingservice.client;

import com.studentinformationsystem.courseschedulingservice.dto.clientDtos.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service",path = "/v1/courses")
public interface CourseServiceClient {
    @GetMapping("/{courseId}")
    ResponseEntity<CourseDto> getById(@PathVariable String courseId);

}
