package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Comentario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ComentarioResponseDTO {
    Long idComentario;

    String comentario;

    Instant instant;

    Long id_client;

    String name;

    Long id_roteiro;

    public ComentarioResponseDTO(Comentario comentario) {
        this.idComentario = comentario.getIdComentario();
        this.comentario = comentario.getComentario();
        this.instant = comentario.getInstant();
        this.id_client = comentario.getClient().getId_client();
        this.name = comentario.getClient().getName();
        this.id_roteiro = comentario.getRoteiro().getId_roteiro();
    }
}
