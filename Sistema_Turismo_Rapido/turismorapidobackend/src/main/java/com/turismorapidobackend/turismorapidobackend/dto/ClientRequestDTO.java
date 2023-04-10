package com.turismorapidobackend.turismorapidobackend.dto;
import java.time.LocalDate;
import java.util.List;

import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Role;
import com.turismorapidobackend.turismorapidobackend.model.Roteiro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import static com.turismorapidobackend.turismorapidobackend.utils.Utils.getNullPropertyNames;

@Data
@AllArgsConstructor
public class ClientRequestDTO extends AbstractRequestDTO {
    
    @NotBlank
    @NotNull
    @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10")
    String name;

    String cpf;
    LocalDate data_nascimento;
    Long tel_number;

    @Email(message = "Informe um email válido")
    @NotBlank(message = "Email é obrigatório")
    String mail;

    @NotBlank(message = "Usuário é obrigatório")
    String username;

    @Size(min = 3, max = 10, message = "Password tem tamanho mínimo de 3 e máximo de 10")
    @NotBlank(message = "Password é obrigatório")
    String password;
    
    String photo;

    RoleName rolename;

    List<Role> roles;

    List<Roteiro> roteiros;

    public ClientRequestDTO(){

    }

//    public Client toClient(){
//        Client client = new Client();
//        BeanUtils.copyProperties(this, client, getNullPropertyNames(this));
//        // client.setRolename(rolename);
//        return client;
//    }

}
