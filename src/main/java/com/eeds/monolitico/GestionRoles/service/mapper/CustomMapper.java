package com.eeds.monolitico.GestionRoles.service.mapper;

public interface CustomMapper<DTO , E>{
    DTO toDto(E e);
    E toEntity(DTO dto);
}
