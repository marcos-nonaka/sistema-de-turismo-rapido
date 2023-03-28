package com.turismorapidobackend.turismorapidobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public List<Client> findAll(String name) {
        if (name.equals("")){
            return clientRepository.findAll();
        }
        else{
            return clientRepository.findBynameIgnoreCase(name);
        }
    }

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Transactional
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO){
        // Verificação de regras

        Client client = clientRequestDTO.toClient();

        Optional<Client> optionalClient = clientRepository.findByUsername(clientRequestDTO.getUsername());

        if(!optionalClient.isPresent()){
            client.setPassword(passwordEncoder().encode(client.getPassword()));
            return new ClientResponseDTO(clientRepository.save(client));
        }

        throw new Error("Usuário já existe!");

    }
    
}
