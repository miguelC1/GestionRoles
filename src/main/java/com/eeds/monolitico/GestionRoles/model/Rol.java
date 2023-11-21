package com.eeds.monolitico.GestionRoles.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    //@SequenceGenerator(name = "rol_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// generator ="rol_sequence" )
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UserRol> userRoles;
}
