package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import java.lang.RuntimeException;
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Long id) {
        super("Id '" + id + "' Not Found!");
    }
}