package com.turismorapidobackend.turismorapidobackend.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_client;
    String name;
    long cpf;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate data_nascimento;
    Long tel_number;

    public Client(){
        
    }
    
}
