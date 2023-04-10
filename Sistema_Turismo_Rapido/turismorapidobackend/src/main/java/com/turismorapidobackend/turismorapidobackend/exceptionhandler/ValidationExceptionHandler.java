package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDTO> handleNotValid(
    MethodArgumentNotValidException exception, 
    HttpServletRequest request) {
    List<ErrorDTO> errors = new ArrayList<>();
    exception
            .getBindingResult()
            .getAllErrors()
            .forEach(error -> {
                errors.add(new ErrorDTO(
                            Instant.now(),
                            HttpStatus.BAD_REQUEST.value(),
                            ((FieldError) error).getField(),
                            error.getDefaultMessage(),
                            request.getRequestURI()));
            });
    return errors;
}

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@ExceptionHandler(Exception.class)
public ErrorDTO handleException(
    Exception exception, 
    HttpServletRequest request) {
    ErrorDTO errorDTO = new ErrorDTO();
    errorDTO.setTimestamp(Instant.now());
    errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
    errorDTO.setError("resource not found");
    errorDTO.setMessage(exception.getMessage());
    errorDTO.setPath(request.getRequestURI());
    return errorDTO;
}


}


