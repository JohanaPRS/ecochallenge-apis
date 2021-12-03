package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ods")
public class Ods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ods", nullable = false)
    private int id;

    @Column(name = "mensaje_ods", nullable = false)
    private String mensaje_ods;

}