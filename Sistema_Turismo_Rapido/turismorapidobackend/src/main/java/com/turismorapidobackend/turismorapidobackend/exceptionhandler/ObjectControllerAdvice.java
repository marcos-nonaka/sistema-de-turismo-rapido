package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
//https://pt.linkedin.com/pulse/tratando-erros-e-exce%C3%A7%C3%B5es-com-spring-boot-tiago-perroni
@ControllerAdvice(basePackages = "com.turismorapidobackend.turismorapidobackend.controller")
public class ObjectControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> objectNotFoundException(ObjectNotFoundException objectNotFoundException, HttpServletRequest request){
        MessageExceptionHandler error = new MessageExceptionHandler(Instant.now(), HttpStatus.NOT_FOUND.value(), "Not Found", objectNotFoundException.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
