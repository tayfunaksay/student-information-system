package com.studentinformationsystem.studentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessRulesException extends RuntimeException {
    public BusinessRulesException(String message) {
        super(message);
    }
}
