package com.makara.mini.project.exception;

import org.springframework.http.HttpStatus;

public class SuccessResponse extends ApiException{
    public SuccessResponse(String message, Long id) {
        super(HttpStatus.valueOf(200), "%s With id = %d Delete Success".formatted("Brand", id));
    }
}
