package com.eeds.monolitico.GestionRoles.repository;


import com.eeds.monolitico.GestionRoles.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}
