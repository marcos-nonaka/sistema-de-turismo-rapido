package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;
import com.turismorapidobackend.turismorapidobackend.model.Roteiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoteiroRepository extends JpaRepository<Roteiro, Long> {
    List<Roteiro> findByNameContainingIgnoreCase(String hotelName);
    List<Roteiro>  findByIdRoteiroAndNameContainingIgnoreCase(Long id, String name);
    // Optional<Roteiro> findByIdClient(Long client_id); perguntar ao Thalyson

}
