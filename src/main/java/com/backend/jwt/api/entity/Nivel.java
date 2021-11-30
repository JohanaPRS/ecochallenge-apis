package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nivel")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel", nullable = false)
    private int id;

    @Column(name = "descripcion_nivel", nullable = false)
    private String descripcion;

    @Column(name = "rango_minimo", nullable = false)
    private int rango_minimo;

    @Column(name = "rango_maximo", nullable = false)
    private int rango_maximo;



}
