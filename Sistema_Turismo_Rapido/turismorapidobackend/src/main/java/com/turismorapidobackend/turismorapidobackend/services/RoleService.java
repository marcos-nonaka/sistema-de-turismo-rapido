package com.turismorapidobackend.turismorapidobackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.RoleRequestDTO;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.model.Role;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;

@Service
public class RoleService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientRequestDTO clientRequestDTO;
    
    public ClientRequestDTO save(RoleRequestDTO roleRequestDTO){
        Optional<ClientRequestDTO> optionalClient;

        List<Role> roles = new ArrayList<>();

        if(optionalClient.isEmpty()){
            throw new Error("Usuário não encontrado!");
        }

        roles = roleRequestDTO.getId_roles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        ClientRequestDTO clientRequestDTO = optionalClient.get();

        clientRequestDTO.setRoles(roles);

        clientRepository.save(clientRequestDTO);
        
        return clientRequestDTO;

    }
}
