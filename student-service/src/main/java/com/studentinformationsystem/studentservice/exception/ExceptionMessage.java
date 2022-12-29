package com.studentinformationsystem.studentservice.exception;

public record ExceptionMessage(String timestamp,
                               int status,
                               String error,
                               String message,
                               String path) {
}
