package com.eeds.monolitico.GestionRoles.repository;


import com.eeds.monolitico.GestionRoles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
