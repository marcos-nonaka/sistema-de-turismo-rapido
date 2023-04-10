package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComentarioRequestDTO extends AbstractRequestDTO {

    Long idComentario;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Descrição precisa ser preenchido")
    @Size(min = 10, max = 300, message = "Descrição tem tamanho mínimo de 10 e máximo de 300")
    String comentario;
    
    Long id_client;
    Long id_roteiro;

    public ComentarioRequestDTO() {
    }
}
