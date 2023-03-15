package com.turismorapidobackend.turismorapidobackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Turista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_turista;

    public Turista(){

    }

    
}
