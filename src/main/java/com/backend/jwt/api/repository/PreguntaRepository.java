package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta,Integer> {

    @Query("SELECT h FROM Pregunta h WHERE h.id = :id")
    Pregunta findPregunta(@Param("id") int id);

}
