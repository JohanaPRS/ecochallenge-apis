package com.backend.jwt.api.repository;

import com.backend.jwt.api.entity.Ods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OdsRepository extends JpaRepository<Ods,Integer> {

    @Query("SELECT h FROM Ods h WHERE h.id = :id")
    Ods findById(@Param("id") int id);

    @Query(value = "SELECT mensaje_ods FROM ods", nativeQuery = true)
    List<Object> findMessages();
}

