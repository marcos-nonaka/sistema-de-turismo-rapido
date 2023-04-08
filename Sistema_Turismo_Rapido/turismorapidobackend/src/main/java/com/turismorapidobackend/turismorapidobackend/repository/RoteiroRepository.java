package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Hotel;
import com.turismorapidobackend.turismorapidobackend.model.Roteiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoteiroRepository extends JpaRepository<Roteiro, Long> {
    List<Roteiro> findByNameContainingIgnoreCase(String hotelName);
    List <Roteiro>  findByIdRoteiroAndNameContainingIgnoreCase(Long id, String name);

}
