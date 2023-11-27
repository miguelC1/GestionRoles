package com.eeds.monolitico.GestionRoles.repository;


import com.eeds.monolitico.GestionRoles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select u.username, u.email, u.create_at from users u", nativeQuery = true)
    List<Object[]> listarUsuarioNormal();

    @Query(value = "select u.id, u.username, u.email, u.create_at, d.first_name, d.last_name, d.age, d.birth_day " +
            "from users u, user_details d where u.id=d.user_id", nativeQuery = true)
    List<Object[]> listarDetallado();
}
