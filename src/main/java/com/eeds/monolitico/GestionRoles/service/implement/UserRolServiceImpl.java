package com.eeds.monolitico.GestionRoles.service.implement;

import com.eeds.monolitico.GestionRoles.model.UserRol;
import com.eeds.monolitico.GestionRoles.repository.UserRolRepository;
import com.eeds.monolitico.GestionRoles.service.UserRolService;

import java.util.List;

public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;

    public UserRolServiceImpl(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRol> listarUserRol() {
        return userRolRepository.findAll();
    }

    @Override
    public UserRol guardar(UserRol userRol) {
        return userRolRepository.save(userRol);
    }
}
