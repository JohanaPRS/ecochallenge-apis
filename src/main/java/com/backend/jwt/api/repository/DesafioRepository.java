package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesafioRepository extends JpaRepository<Desafio,Integer> {

    @Query("SELECT h FROM Desafio h WHERE h.id = :id")
    Desafio findOne(@Param("id") int id);

    List<Desafio> findByStatus(@Param("status") Boolean status);

}
