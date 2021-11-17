package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.backend.jwt.api.entity.Rol;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "desafio")
public class Desafio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desafio", nullable = false)
    private int id;

    @Column(name = "nombre_desafio", nullable = false)
    private String nombre_desafio;

    @Column(name = "estado_desafio",columnDefinition = "tinyint(1) default true")
    private Boolean estado_desafio = true;

    @Column(name = "puntaje_desafio", nullable = false)
    private int puntaje_desafio;

    @Column(name = "paso1Desafio", nullable = false)
    private String paso1Desafio;

    @Column(name = "paso2Desafio", nullable = false)
    private String paso2Desafio;

    @Column(name = "paso3Desafio", nullable = false)
    private String paso3Desafio;

    @Column(name = "paso4Desafio")
    private String paso4Desafio;

    public Desafio(Boolean estado_desafio) {
        this.estado_desafio = estado_desafio;
    }
}
