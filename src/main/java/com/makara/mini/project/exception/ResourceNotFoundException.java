package com.makara.mini.project.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {
    public ResourceNotFoundException(String resourceName, Long id) {
        super(HttpStatus.NOT_FOUND, "%s With id = %d not fond".formatted(resourceName, id));
    }
}
