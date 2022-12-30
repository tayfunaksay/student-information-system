package com.studentinformationsystem.courseschedulingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HourNotFoundException extends RuntimeException{
    public HourNotFoundException(String message) {
        super(message);
    }
}
