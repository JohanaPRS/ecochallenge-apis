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

    //@Column(name = "usuario", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",referencedColumnName="id_usuario")
    private User usuario;

    //@Column(name = "nivel", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel",referencedColumnName="id_nivel")
    private Nivel nivel;

    @Column(name = "puntaje_total", nullable = false)
    private int puntaje_total;


}
