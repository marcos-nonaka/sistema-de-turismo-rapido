package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CidadeRequestDTO extends AbstractRequestDTO {
    Long idCidade;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Campo Nome precisa ser preenchido")
    @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10")
    String name;

    Long cep;

    @NotBlank(message="Campo longitude não pode ser vazio")
    @NotNull(message="Campo longitude precisa ser preenchido")
    Double longitude;

    @NotBlank(message="Campo latitude não pode ser vazio")
    @NotNull(message="Campo latitude precisa ser preenchido")
    Double latitude;

    public CidadeRequestDTO() {
    }
}
