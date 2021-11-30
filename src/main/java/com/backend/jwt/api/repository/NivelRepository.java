package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Desafio;
import com.backend.jwt.api.entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NivelRepository extends JpaRepository<Nivel,Integer> {

    ///select nivel desde puntaje de jugador al terminar desafio
    @Query("SELECT h FROM Nivel h WHERE (h.rango_minimo <= :rango_minimo) and (h.rango_maximo >= :rango_maximo)")
    Nivel findByRango(@Param("rango_minimo") int rango_minimo, @Param("rango_maximo") int rango_maximo);

    @Query("SELECT h FROM Nivel h WHERE h.descripcion LIKE '%descripcion%'")
    List<Nivel> findByDescripcion(@Param("descripcion") String descripcion);

    @Query("SELECT h FROM Nivel h WHERE h.id = :id")
    Nivel findById(@Param("id") int id);
}

