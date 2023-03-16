package com.turismorapidobackend.turismorapidobackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismorapidobackend.turismorapidobackend.model.Turista;

@Repository
public interface TuristaRepository extends JpaRepository<Turista, Long> {
    
}
