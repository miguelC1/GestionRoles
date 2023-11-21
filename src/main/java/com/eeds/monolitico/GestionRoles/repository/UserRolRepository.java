package com.eeds.monolitico.GestionRoles.repository;


import com.eeds.monolitico.GestionRoles.model.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRolRepository extends JpaRepository<UserRol,Long> {
}
