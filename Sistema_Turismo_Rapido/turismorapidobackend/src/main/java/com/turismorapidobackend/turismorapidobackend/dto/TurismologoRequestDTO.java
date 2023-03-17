package com.turismorapidobackend.turismorapidobackend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TurismologoRequestDTO {
    Long id_turismologo;
    String something;
    String name;
    String cpf;
    LocalDate data_nascimento;
    Long tel_number;
    String mail;
    String username;
    String password;

    public TurismologoRequestDTO(){
        
    }
}
