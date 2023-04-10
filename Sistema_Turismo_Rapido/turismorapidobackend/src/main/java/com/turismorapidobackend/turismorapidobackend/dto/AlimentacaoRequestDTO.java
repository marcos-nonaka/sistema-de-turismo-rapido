package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlimentacaoRequestDTO extends AbstractRequestDTO {
    Long id_alimentacao;

    Long id_cidade;

    @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10")
    @NotBlank(message = "O campo nome é obrigatório")
    String local_name;

    @Size(min = 50, max = 200, message = "Nome tem tamanho mínimo de 50 e máximo de 200")
    @NotBlank(message = "O campo Descrição é obrigatório")
    String description;

    @Pattern(regexp = "\\d{2}) \\d{4}-\\d{4}")
    String phone_number;

    String street_name;

    String street_district;

    int street_number;

    Double longitude;

    Double latitude;

    public AlimentacaoRequestDTO() {
    }
}
