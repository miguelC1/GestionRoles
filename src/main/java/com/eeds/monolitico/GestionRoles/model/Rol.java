package com.eeds.monolitico.GestionRoles.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UserRol> userRoles;
}
