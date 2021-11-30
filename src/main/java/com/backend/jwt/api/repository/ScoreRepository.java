package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Integer> {

    @Query("SELECT h FROM Score h WHERE h.id = :id")
    Score findScore(@Param("id") int id);

    ///get total points for one user:
    @Query("SELECT SUM(s.puntos) FROM Score s WHERE s.id_usuario = :id_usuario GROUP BY s.id_usuario")
    int getTotalScoreForUser(@Param("id_usuario") int id_usuario);
}
