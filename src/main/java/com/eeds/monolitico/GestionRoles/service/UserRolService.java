package com.eeds.monolitico.GestionRoles.service;

import com.eeds.monolitico.GestionRoles.model.User;
import com.eeds.monolitico.GestionRoles.model.UserRol;

import java.util.List;

public interface UserRolService {
    List<UserRol> listarUserRol();
    UserRol guardar(UserRol userRol);
}
