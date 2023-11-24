package com.eeds.monolitico.GestionRoles.service.mapper;

import com.eeds.monolitico.GestionRoles.dto.RolDTO;
import com.eeds.monolitico.GestionRoles.model.Rol;

public class RolMapper implements CustomMapper<RolDTO, Rol> {
    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO rolDTO= new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
        return rolDTO;
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol= new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }
}
