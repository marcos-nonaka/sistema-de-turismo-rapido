package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
