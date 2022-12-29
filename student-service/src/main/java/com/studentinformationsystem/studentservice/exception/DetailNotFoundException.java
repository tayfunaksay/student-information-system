package com.studentinformationsystem.studentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DetailNotFoundException extends RuntimeException {
    private ExceptionMessage exceptionMessage;
    public DetailNotFoundException(String message) {
        super(message);
    }

    public DetailNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public DetailNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
