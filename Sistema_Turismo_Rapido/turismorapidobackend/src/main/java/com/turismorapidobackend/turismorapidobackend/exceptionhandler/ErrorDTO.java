package com.turismorapidobackend.turismorapidobackend.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {

    String field;
    String error;
    
}
