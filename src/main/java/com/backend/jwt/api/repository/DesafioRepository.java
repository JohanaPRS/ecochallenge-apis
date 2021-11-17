package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafioRepository extends JpaRepository<Desafio,Integer> {
    Desafio findById(int id);
}
