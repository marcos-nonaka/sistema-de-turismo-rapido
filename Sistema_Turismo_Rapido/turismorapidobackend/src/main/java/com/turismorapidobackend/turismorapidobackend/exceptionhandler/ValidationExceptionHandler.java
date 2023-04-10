package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

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
    public List<ErrorDTO> HandleMethotdArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorDTO> errors = new ArrayList<>();

        exception
            .getBindingResult()
            .getAllErrors()
            .forEach(error -> {
                errors.add(new ErrorDTO((((FieldError) error).getField()), error.getDefaultMessage()));
            });
        return errors;
   }

}

