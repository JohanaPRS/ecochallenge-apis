package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private int id_rol;

    @Column(name = "nombre_rol", nullable = false)
    private String nombre_rol;

    @Column(name = "descripcion_rol", nullable = false)
    private String descripcion_rol;

    public Rol(int id_rol) {
        this.id_rol = id_rol;
    }
}