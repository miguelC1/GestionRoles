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
    User obtenerUserPorId(Long id);
    UserInput obtenerUserDetalladoPorId(Long id);
    List<UserDetalleDTO> listarDetallado();
    List<UserDTO> listarNormal();
    User editar(Long UserIdU, UserInput user);
    void eliminar(Long id);


}
