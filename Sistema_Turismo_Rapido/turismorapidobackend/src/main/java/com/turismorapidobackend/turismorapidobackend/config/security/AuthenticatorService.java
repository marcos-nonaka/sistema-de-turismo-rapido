package com.turismorapidobackend.turismorapidobackend.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;

@Service
public class AuthenticatorService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> clientOptional = clientRepository.findByUsername(username);
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }
        throw new UsernameNotFoundException("Usuário não encontrado!");
    }
    
}
