package com.rotaurbana.rotaurbanaapi.exception;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends ApiException {

    public DuplicateResourceException(String resource, String field, Object value) {
        super("%s already exists with %s: %s".formatted(resource, field, value), HttpStatus.CONFLICT);
    }
}
