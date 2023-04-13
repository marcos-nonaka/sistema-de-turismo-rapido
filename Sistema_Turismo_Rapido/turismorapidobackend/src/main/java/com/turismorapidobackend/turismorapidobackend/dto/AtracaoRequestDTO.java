package com.turismorapidobackend.turismorapidobackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtracaoRequestDTO extends AbstractRequestDTO {
    Long idAtracao;

    Long id_cidade;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Campo Nome precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Nome tem tamanho mínimo de 3 e máximo de 100")
    String name;

    // @Pattern(regexp = "\\d{2}) \\d{4}-\\d{4}", message="Telefone inválido")
    // @NotNull(message = "Telefone obrigatório")
    // @NotEmpty(message="Insira o telefone")
    Long tel_number;

    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Campo Rua precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Rua tem tamanho mínimo de 3 e máximo de 100")
    String endereco;

    @Size(min = 50, max = 500, message = "Nome tem tamanho mínimo de 50 e máximo de 500")
    @NotBlank(message = "O campo Descrição é obrigatório")
    String descricao;

    String tipo;

    @NotNull(message="Campo longitude precisa ser preenchido")
    Double longitude;

    @NotNull(message="Campo latitude precisa ser preenchido")
    Double latitude;

    public AtracaoRequestDTO() {
    }
}
