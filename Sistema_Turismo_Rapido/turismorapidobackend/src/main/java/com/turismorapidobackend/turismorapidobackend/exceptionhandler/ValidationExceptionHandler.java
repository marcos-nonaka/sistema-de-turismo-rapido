package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Map<String, String>> HandleMethotdArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<Map<String, String>> errors = new ArrayList<>();
        exception
            .getBindingResult()
            .getAllErrors()
            .forEach(error -> {
                Map<String, String> entry = new HashMap<>();
                entry.put("field", ((FieldError) error).getField());
                entry.put("error", error.getDefaultMessage());
                errors.add(entry);
            });
        return errors;
   }

}

