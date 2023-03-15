package com.turismorapidobackend.turismorapidobackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismorapidobackend.turismorapidobackend.model.Client;
import com.turismorapidobackend.turismorapidobackend.repository.ClientRepository;

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
    
}
