package com.turismorapidobackend.turismorapidobackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismorapidobackend.turismorapidobackend.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    List <Client> findAllByName(String name);
    List <Client> findBynameIgnoreCase(String name);
    Optional<Client> findByUsername(String username);
}
