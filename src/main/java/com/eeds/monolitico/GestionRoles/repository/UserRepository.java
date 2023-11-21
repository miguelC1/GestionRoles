package com.eeds.monolitico.GestionRoles.repository;


import com.eeds.monolitico.GestionRoles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
