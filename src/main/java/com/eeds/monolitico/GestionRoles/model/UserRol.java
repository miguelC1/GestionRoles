package com.eeds.monolitico.GestionRoles.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;

}
