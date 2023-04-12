package com.turismorapidobackend.turismorapidobackend.dto;
import java.time.LocalDate;
import java.util.List;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import com.turismorapidobackend.turismorapidobackend.model.Role;
import com.turismorapidobackend.turismorapidobackend.model.Roteiro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequestDTO extends AbstractRequestDTO {
    @NotBlank(message="Campo não pode ser vazio")
    @NotNull(message="Campo Nome precisa ser preenchido")
    @Size(min = 3, max = 100, message = "Nome tem tamanho mínimo de 3 e máximo de 100")
    String name;

    // @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Formato de data inválida")
    // @NotNull(message = "Data de nascimento obrigatório")
    // @NotEmpty(message="Insira a data de nascimento")
    LocalDate data_nascimento;

    // @Pattern(regexp = "\\d{2}) \\d{4}-\\d{4}")
    // @NotNull(message = "Telefone obrigatório")
    // @NotEmpty(message="Insira o telefone")
    Long tel_number;

    @Email(message = "Informe um email válido")
    @NotBlank(message = "Email é obrigatório")
    @NotNull(message="Insira um email")
    String mail;

    @NotBlank(message = "Usuário é obrigatório")
    @Size(min = 5, max = 50, message="Usuário tem tamanho mínimo de 5 e máximo de 50")
    @NotNull(message="Insira um nome de usuário")
    String username;

    @Size(min = 3, max = 50, message = "Password tem tamanho mínimo de 3 e máximo de 50")
    @NotBlank(message = "Password é obrigatório")
    String password;
    
    String photo;

    RoleName rolename;

    Long cpf;

    List<Role> roles;

    List<Roteiro> roteiros;

    public ClientRequestDTO(){

    }
}
