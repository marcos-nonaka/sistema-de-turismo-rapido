package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Atracao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtracaoRepository extends JpaRepository<Atracao, Long> {
    List<Atracao> findByNameContainingIgnoreCase(String name);
    List <Atracao>  findByIdAtracaoAndNameContainingIgnoreCase(Long id, String name);
}
