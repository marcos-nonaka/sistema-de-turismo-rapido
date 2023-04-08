package com.turismorapidobackend.turismorapidobackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    Long idComentario;

    String comentario;

    Instant instant;

    @PrePersist
    public void prePersist() {
        this.instant = Instant.now();
    }

    @OneToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    Client client;

    @OneToOne(targetEntity = Roteiro.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "roteiro_id")
    Roteiro roteiro;
}
