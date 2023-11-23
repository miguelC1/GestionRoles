package com.eeds.monolitico.GestionRoles.service;

import com.eeds.monolitico.GestionRoles.dto.UserDTO;
import com.eeds.monolitico.GestionRoles.dto.UserDetalleDTO;
import com.eeds.monolitico.GestionRoles.input.UserInput;
import com.eeds.monolitico.GestionRoles.model.Rol;
import com.eeds.monolitico.GestionRoles.model.User;

import java.util.List;

public interface UserService {
    List<User> listarUsuarios();
    User guardar(UserInput user);
    List<UserDetalleDTO> listarDetallado();
    List<UserDTO> listarNormal();
    User actualizar(User user);
    void eliminar(Long id);
}
