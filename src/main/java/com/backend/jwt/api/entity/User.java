package com.backend.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.backend.jwt.api.entity.Rol;
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private int id;

    @Column(name = "nombre_usuario", nullable = false)
    private String userName;

    @Column(name = "apellido_usuario", nullable = false)
    private String apellido_usuario;

    @Column(name = "edad_usuario", nullable = false)
    private int edad_usuario;

    @Column(name = "email_usuario", nullable = false)
    private String email;

    @Column(name = "contrasenia_usuario", nullable = false)
    private String password;

    @Column(name = "estado_usuario", columnDefinition = "tinyint(1) default true")
    private Boolean estado_usuario = true;

    @Column(name = "id_rol", columnDefinition = "INT(1) default '1'")
    private int id_rol = 1;

    @Column(name = "id_nivel", columnDefinition = "INT(1) default '1'")
    private int id_nivel = 1;

    @Column(name = "puntaje", nullable = false)
    private int puntaje;

    public User(String userName, String apellido_usuario, int edad_usuario, String email, String password) {
        this.userName = userName;
        this.apellido_usuario = apellido_usuario;
        this.edad_usuario = edad_usuario;
        this.email = email;
        this.password = password;
    }
}
