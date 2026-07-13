package com.rotaurbana.rotaurbanaapi.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(String resource, Object identifier) {
        super("%s not found with identifier: %s".formatted(resource, identifier), HttpStatus.NOT_FOUND);
    }
}
