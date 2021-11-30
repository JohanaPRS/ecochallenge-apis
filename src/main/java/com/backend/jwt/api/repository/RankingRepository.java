package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Ranking;
import com.backend.jwt.api.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking,Integer> {

    @Query("SELECT h FROM Ranking h WHERE h.id = :id")
    Ranking findRanking(@Param("id") int id);

   //@Query("SELECT SUM(s.score) FROM Ranking s WHERE s.usuario = :userId GROUP BY s.usuario")
   //Integer getTotalScoreForUser(@Param("usuario") int usuario);

    @Query("SELECT s.usuario, s.puntaje_total FROM Ranking s GROUP BY s.usuario ORDER BY s.puntaje_total DESC")
    List<Ranking> findFirst();

}