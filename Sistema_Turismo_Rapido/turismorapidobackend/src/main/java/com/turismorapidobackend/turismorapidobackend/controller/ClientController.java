package com.turismorapidobackend.turismorapidobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientResponseDTO;
import com.turismorapidobackend.turismorapidobackend.dto.RoleRequestDTO;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.services.ClientService;
import com.turismorapidobackend.turismorapidobackend.services.RoleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<ClientResponseDTO> find(@RequestParam(name="name", defaultValue="") String name){
        
        List<Client> list = clientService.findAll(name);

        return list.stream().map(ClientResponseDTO:: new).toList();
    }

    @PostMapping
    public ClientResponseDTO save(@RequestBody ClientRequestDTO clientRequestDTO) {

        return clientService.save(clientRequestDTO);
        
    }

    @PostMapping("/role")
    public List<ClientResponseDTO> defineUserRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return roleRequestDTO.save(roleRequestDTO);
    }
    
    
    
}
