package com.studentinformationsystem.courseschedulingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassroomNotFoundException extends RuntimeException{
    public ClassroomNotFoundException(String message) {
        super(message);
    }
}
