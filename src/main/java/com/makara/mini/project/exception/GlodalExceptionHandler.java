package com.makara.mini.project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlodalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException e) {
        ErrorResponse  errorResponse = new ErrorResponse(e.getStatus(),e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(errorResponse);
    }
}
