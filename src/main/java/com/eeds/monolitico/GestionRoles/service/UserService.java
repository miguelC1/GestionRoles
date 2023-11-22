package com.eeds.monolitico.GestionRoles.service;

import com.eeds.monolitico.GestionRoles.input.UserInput;
import com.eeds.monolitico.GestionRoles.model.User;

import java.util.List;

public interface UserService {
    List<User> listarUsuarios();
    User guardar(UserInput user);
}
