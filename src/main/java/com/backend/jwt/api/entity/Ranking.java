package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ranking", nullable = false)
    private int id;

    @Column(name = "id_usuario", nullable = false)
    private int id_usuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombre_usuario;

    @Column(name = "id_nivel", nullable = false)
    private int id_nivel;

    @Column(name = "puntaje_total", nullable = false)
    private int puntaje_total;

    public Ranking(int id_usuario, String nombre_usuario, int id_nivel, int puntaje_total) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.id_nivel = id_nivel;
        this.puntaje_total = puntaje_total;
    }

    public Ranking(int id_usuario, String nombre_usuario, int puntaje_total) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.puntaje_total = puntaje_total;
    }
}
