package com.eeds.monolitico.GestionRoles.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rols")
public class Rol {
    @Id
    //@SequenceGenerator(name = "rol_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// generator ="rol_sequence" )
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
