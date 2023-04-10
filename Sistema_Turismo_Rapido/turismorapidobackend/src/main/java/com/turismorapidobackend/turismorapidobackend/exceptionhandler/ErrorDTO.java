package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {

    Instant timestamp;
    Integer status;
    String error;
    String message;
    String path;

    public ErrorDTO(){

    }
    
}
