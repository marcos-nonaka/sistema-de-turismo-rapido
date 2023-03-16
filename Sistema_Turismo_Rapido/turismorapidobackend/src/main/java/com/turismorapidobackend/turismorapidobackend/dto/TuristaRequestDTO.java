package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TuristaRequestDTO {
    Long id_turista;
    String something;
    String name;

    public TuristaRequestDTO(){
        
    }
}
