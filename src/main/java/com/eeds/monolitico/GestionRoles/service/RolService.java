package com.eeds.monolitico.GestionRoles.service;

import com.eeds.monolitico.GestionRoles.model.Rol;

import java.util.List;

public interface RolService {

    List<Rol> listarRoles();
    Rol obtenerRolPorId(Long id);
    Rol guardar(Rol rol);
    Rol actualizar( Rol rol);
    void eliminar(Long id);

}
