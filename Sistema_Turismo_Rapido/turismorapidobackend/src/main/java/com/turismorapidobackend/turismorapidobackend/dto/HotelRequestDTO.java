package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelRequestDTO extends AbstractRequestDTO {
    Long idCidade;

    @Size(min = 3, max = 100, message = "Nome tem tamanho mínimo de 3 e máximo de 100")
    @NotBlank(message = "O campo nome do local é obrigatório")
    String hotelName;

    Long phone_number;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Campo Rua precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Rua tem tamanho mínimo de 3 e máximo de 100")
    String street_name;

    int street_number;

    @NotBlank(message="Campo rua não pode ser vazio")
    @NotNull(message="Campo Municipio precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Municipio tem tamanho mínimo de 3 e máximo de 100")
    String street_district;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Descrição precisa ser preenchido")
    @Size(min = 10, max = 1000, message = "Descrição tem tamanho mínimo de 10 e máximo de 1000")
    String description_hotel;

    @NotNull(message="Campo longitude precisa ser preenchido")
    Double longitude;

    @NotNull(message="Campo latitude precisa ser preenchido")
    Double latitude;

    public HotelRequestDTO(){

    }

}
