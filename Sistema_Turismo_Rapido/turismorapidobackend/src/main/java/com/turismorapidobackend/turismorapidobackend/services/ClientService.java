package com.turismorapidobackend.turismorapidobackend.services;

import java.util.List;
import java.util.Optional;

import com.turismorapidobackend.turismorapidobackend.dto.RoleRequestDTO;
import com.turismorapidobackend.turismorapidobackend.enums.RoleName;
import com.turismorapidobackend.turismorapidobackend.model.Cidade;
import com.turismorapidobackend.turismorapidobackend.model.Role;
import com.turismorapidobackend.turismorapidobackend.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.turismorapidobackend.turismorapidobackend.exceptionhandler.ObjectNotFoundException;
import com.turismorapidobackend.turismorapidobackend.dto.ClientRequestDTO;
import com.turismorapidobackend.turismorapidobackend.dto.ClientResponseDTO;
import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;

import jakarta.transaction.Transactional;

import static com.turismorapidobackend.turismorapidobackend.utils.Utils.getNullPropertyNames;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;


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
        Client client = (Client) clientRequestDTO.toObject(new Client());

        Optional<Client> optionalClient = clientRepository.findByUsername(clientRequestDTO.getUsername());

        if(!optionalClient.isPresent()){
            client.setPassword(passwordEncoder().encode(client.getPassword()));

            RoleName roleName = clientRequestDTO.getRolename();

            if(roleName == RoleName.ROLE_ADMIN){
                throw new Error("Acesso não autorizado!");
            }

            Role role = roleRepository.findByRole(roleName).get();
            

            client.setRoles( List.of(role) );

            return new ClientResponseDTO(clientRepository.save(client));
        }

        throw new Error("Usuário já existe!");

    }

    public ClientResponseDTO addRole(RoleRequestDTO roleRequestDTO) {
        Client client = clientRepository.findById(roleRequestDTO.getClient_id()).get();
        Role role = roleRepository.findByRole(roleRequestDTO.getRoleName()).get();

        if( !client.getRoles().contains(role) ){
            client.getRoles().add(role);
        }

        return new ClientResponseDTO(clientRepository.save(client));
    }

    @Transactional
    public Client findById(Optional<Long> id) {
        Optional<Client> client = clientRepository.findById(id.get());
        if (id.isPresent()) {
            return client.orElseThrow(() -> new ObjectNotFoundException(id.get()));
        } else {
            return null;
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Optional<Long> id) {
        clientRepository.delete(this.findById(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    public ResponseEntity<Object> update(Optional<Long> id, ClientRequestDTO clientRequestDTO) {
        Client client = this.findById(id);
        clientRequestDTO.setPassword(passwordEncoder().encode(clientRequestDTO.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientResponseDTO(clientRepository.save((Client) clientRequestDTO.toObject(client))));
    }
}
