package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComentarioRequestDTO extends AbstractRequestDTO {

    Long idComentario;
    String comentario;
    Long id_client;
    Long id_roteiro;

    public ComentarioRequestDTO() {
    }
}
