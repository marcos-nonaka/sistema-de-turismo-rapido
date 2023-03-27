package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Roteiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoteiroRepository extends JpaRepository<Roteiro, Long> {
    
}
