package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Turismologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_turismologo;

    @OneToOne(targetEntity = Client.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    Client client;

    public Turismologo() {
    }
}
