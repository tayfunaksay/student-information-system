package com.studentinformationsystem.courseschedulingservice.client;

import com.studentinformationsystem.courseschedulingservice.dto.clientDtos.ClassroomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "registrar-service",path = "/v1/classrooms")
public interface RegistrarServiceClient {
    @GetMapping("/{classroomId}")
    ResponseEntity<ClassroomDto> getById(@PathVariable(value = "classroomId") String classroomId);
}
