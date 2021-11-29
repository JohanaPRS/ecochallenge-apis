package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking,Integer> {

    @Query("SELECT h FROM Ranking h WHERE h.id = :id")
    Ranking findOne(@Param("id") int id);

    //@Query("SELECT SUM(s.score) FROM Ranking s WHERE s.usuario = :userId GROUP BY s.usuario")
   //Integer getTotalScoreForUser(@Param("usuario") int usuario);


}