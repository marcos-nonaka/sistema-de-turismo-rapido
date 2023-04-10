package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

   @ResponseStatus(code = HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public String handle1(MethodArgumentNotValidException exception) {
       return "Error";
   }

   @ResponseStatus(code = HttpStatus.BAD_REQUEST)
   @ExceptionHandler(HttpMessageNotReadableException.class)
   public String handle2(HttpMessageNotReadableException exception) {
       return "Error 2";
   }

}

