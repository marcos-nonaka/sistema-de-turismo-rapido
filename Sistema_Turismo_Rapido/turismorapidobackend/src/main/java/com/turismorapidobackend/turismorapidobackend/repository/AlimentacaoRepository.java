package com.turismorapidobackend.turismorapidobackend.repository;

import com.turismorapidobackend.turismorapidobackend.model.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {
}
