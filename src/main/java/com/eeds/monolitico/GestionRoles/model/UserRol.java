package com.eeds.monolitico.GestionRoles.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    //@SequenceGenerator(name = "user_rol_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;

}
