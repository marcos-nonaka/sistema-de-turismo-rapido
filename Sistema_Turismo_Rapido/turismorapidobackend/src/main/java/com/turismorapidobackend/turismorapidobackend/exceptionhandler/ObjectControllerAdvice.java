package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
@ControllerAdvice(basePackages = "com.turismorapidobackend.turismorapidobackend.controller")
public class ObjectControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> objectNotFoundException(ObjectNotFoundException objectNotFoundException, HttpServletRequest request){
        MessageExceptionHandler error = new MessageExceptionHandler(Instant.now(), objectNotFoundException.getHttpStatus().value(), objectNotFoundException.getHttpStatus().getReasonPhrase(), objectNotFoundException.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, objectNotFoundException.getHttpStatus());
    }
}
