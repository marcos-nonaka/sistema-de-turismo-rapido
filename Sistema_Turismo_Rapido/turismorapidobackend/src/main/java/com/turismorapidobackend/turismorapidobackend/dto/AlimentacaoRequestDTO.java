package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlimentacaoRequestDTO extends AbstractRequestDTO {
    Long id_alimentacao;

    Long id_cidade;

    @Size(min = 3, max = 100, message = "Nome tem tamanho mínimo de 3 e máximo de 100")
    @NotBlank(message = "O campo nome do local é obrigatório")
    String local_name;

    @Size(min = 50, max = 500, message = "Nome tem tamanho mínimo de 50 e máximo de 500")
    @NotBlank(message = "O campo Descrição é obrigatório")
    String description;

    // @Pattern(regexp = "\\d{2}) \\d{4}-\\d{4}", message="Telefone inválido")
    // @NotNull(message = "Telefone obrigatório")
    // @NotEmpty(message="Insira o telefone")
    String phone_number;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Campo Rua precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Rua tem tamanho mínimo de 3 e máximo de 100")
    String street_name;

    @NotBlank(message="Campo rua não pode ser vazio")
    @NotNull(message="Campo Municipio precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Municipio tem tamanho mínimo de 3 e máximo de 100")
    String street_district;

    @Digits(integer = 4, fraction = 0, message="Verifique se o numero da rua está correto")
    @NotBlank(message="Campo numero da rua não pode ser vazio")
    @NotNull(message="Campo numero da rua precisa ser preenchido")
    int street_number;

    @NotBlank(message="Campo longitude não pode ser vazio")
    @NotNull(message="Campo longitude precisa ser preenchido")
    Double longitude;

    @NotBlank(message="Campo latitude não pode ser vazio")
    @NotNull(message="Campo latitude precisa ser preenchido")
    Double latitude;

    public AlimentacaoRequestDTO() {
    }
}
