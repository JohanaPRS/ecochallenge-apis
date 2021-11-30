package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score", nullable = false)
    private int id;

    @Column(name = "id_desafio")
    private int id_desafio;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "puntos", nullable = false)
    private int puntos;


}
