package com.eeds.monolitico.GestionRoles.repository;


import com.eeds.monolitico.GestionRoles.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository  extends JpaRepository<Rol,Long> {
}
