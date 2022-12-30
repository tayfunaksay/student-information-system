package com.studentinformationsystem.courseschedulingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstructorForCourseNotFoundException extends RuntimeException{
    public InstructorForCourseNotFoundException(String message) {
        super(message);
    }
}
