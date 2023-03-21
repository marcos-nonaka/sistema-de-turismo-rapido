package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Roteiro {
    
    Long id_roteiro;
    
    @ManyToOne(targetEntity = Turismologo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "turismologo_id")
    Turismologo turismologo;

    @ManyToMany(targetEntity = Turista.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "turismologo_id")
    Turista turista;

    @OneToOne(targetEntity = Cidade.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cidade_id")
    Cidade cidade;

    @ManyToMany(targetEntity = Hotel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    Hotel hotel;

    @OneToMany(targetEntity = Alimentacao.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "alimentacao_id")
    Alimentacao alimentacao;
}
