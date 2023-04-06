package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import org.springframework.http.HttpStatus;

import java.lang.RuntimeException;
public class ObjectNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;
    public ObjectNotFoundException() {
        super("No Content");
        this.httpStatus = HttpStatus.NO_CONTENT;
    }
    public ObjectNotFoundException(Long id) {
        super("Id '" + id + "' Not Found!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}