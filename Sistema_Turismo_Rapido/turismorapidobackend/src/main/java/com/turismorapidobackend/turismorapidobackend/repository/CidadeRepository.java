package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List <Cidade>  findByNameContainingIgnoreCase(String name);
    List <Cidade>  findByIdCidadeAndNameContainingIgnoreCase(Long id, String name);
}
