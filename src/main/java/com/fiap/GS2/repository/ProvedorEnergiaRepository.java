package com.fiap.GS2.repository;

import com.fiap.GS2.model.ProvedorEnergia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvedorEnergiaRepository extends JpaRepository<ProvedorEnergia, Long> {
    List<ProvedorEnergia> findByNome(String nome);
}
