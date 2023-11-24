package com.eeds.monolitico.GestionRoles.service;

import com.eeds.monolitico.GestionRoles.dto.UserRolDTO;
import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.model.UserRol;

import java.util.List;

public interface UserRolService {
    List<UserRol> listarUserRol();
    UserRol guardar(UserRolDTO userRolDTOe);
    UserRol inactivarUserRol(Long id);
    List<UserRol> asignarRoles(Long userId, List<Long> rolesIds);
}
