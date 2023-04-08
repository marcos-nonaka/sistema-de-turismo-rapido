package com.turismorapidobackend.turismorapidobackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;

import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@NonNull @PathVariable(name="id") Long id){
        return clientService.findById(id);
    }


    @PostMapping
    public ClientResponseDTO save(@RequestBody ClientRequestDTO clientRequestDTO) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        
        return clientService.save(clientRequestDTO);
        
    }

    @PostMapping("/role")
    public ClientResponseDTO adicionarUserRole(@RequestBody RoleRequestDTO roleRequestDTO){
        return clientService.addRole(roleRequestDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable(name = "id") Long id){
        return clientService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@NonNull @PathVariable(name = "id") Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        return clientService.update(id, clientRequestDTO);
    }
    
}
